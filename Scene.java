import java.util.ArrayList;
abstract public class Scene implements Runnable {
    protected String name;
    protected Thread currentThread;
	protected ArrayList<Object> objects = new ArrayList<Object>();
	protected Output out;

	//Constructor
	public Scene(String n, Output o)
	{
		this.name = n;
		this.out = o;
		this.currentThread = new Thread(this);
		this.currentThread.start();
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
	
    //Run this only once with inital list of objects
	abstract void loadObjects();

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
}