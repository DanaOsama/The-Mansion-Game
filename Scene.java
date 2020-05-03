import java.util.ArrayList;
abstract public class Scene implements Runnable, Observer {
	
    protected String name;
    protected Thread currentThread;
	protected ArrayList<Object> objects = new ArrayList<Object>();
	protected Output out;
	protected int currentState = 0;
	protected Ticker tick;

	//Constructor
	public Scene(String n, Output o, Ticker t)
	{
		this.name = n;
		this.out = o;
		this.currentThread = new Thread(this);
		this.currentThread.start();
		tick = t;
		t.registerObserver(this);

	}

	//Scenes
	protected Scene north = null;
	protected Scene east = null;
	protected Scene south = null;
	protected Scene west = null;

	//Movement functions
	public void goNorth(Game g)
	{
		out.println("Cannot go north, there is nothing there.");
	}

	public void goEast(Game g)
	{
		out.println("Cannot go there, there is nothing there.");
	}
	
	public void goSouth(Game g)
	{
		out.println("Cannot go south, there is nothing there.");
	}

	public void goWest(Game g)
	{
		out.println("Cannot go west, there is nothing there.");	
	}
	
	//Description functions
	void printDescription()
	{
		this.describeSelf();
		this.describeObjects();
		this.describeSurroundings();
	}

	abstract protected void describeSelf();
	
	protected void describeObjects()
	{
		// If there are no objects in the scene
		if (objects.size() == 0)
		{
			out.println("Nothing useful here.");
		}
		else
		{
			out.print(" ");
			for(int i = 0; i < objects.size(); i++)
			{
				out.print(objects.get(i).getSceneDescription() + " ");
			}
			out.println("");
		}
	}
	
	protected void describeSurroundings()
	{
		if (north != null)
		{
			out.println(north.getName() + " is in the north.");
		}

		if (east != null)
		{
			out.println(east.getName() + " is in the east.");
		}

		if (south != null)
		{
			out.println(south.getName() + " is in the south.");
		}
		
		if(west != null)
		{
			out.println(south.getName() + " is in the west.");
		}
	}

    //Run this only once with inital list of objects
	abstract protected void loadObjects();

	boolean findObject(String n)
	{
		for (int i = 0; i < objects.size(); i++)
		{
			if (n.equals(objects.get(i).getName()))
			{
				return true;
			}
		}
		return false;
	}

	Object getObject(String n) throws Exception
	{
		for (int i = 0; i < objects.size(); i++)
		{
			if (n.equals(objects.get(i).getName()))
			{
				return objects.get(i);
			}
		}

		//If the object is not found in the scene, throw an exception
		throw new Exception(n + " was not found in scene " + this.name);
	}

	void takeObject(Object o) throws Exception
	{
		int i = objects.indexOf(o);
		if (i >= 0)
		{
			objects.remove(i);
		}
		else
		{
			//If the object is not found in the scene, throw an exception
            throw new Exception(o.getName() + " was not found in scene " + this.name);
		}
	}

	String getName()
	{
		return this.name;
	}
	
	void addObject(Object obj)
	{
		objects.add(obj);
	}
	
	//Observer function 
	public void update()
	{
		//Now that a tick happened, let's see if the state changed
		if (this.tick.getState() != this.currentState) this.currentState = this.tick.getState();
	}
}