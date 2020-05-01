import java.util.ArrayList;
abstract public class Scene implements Runnable {
    protected String name;
    protected Thread currentThread;
	protected ArrayList<Object> objects = new ArrayList<Object>();
	
    //Run this only once with inital list of objects
	abstract void loadObjects();

	boolean findObject(String n)
	{
		for (int i = 0; i < objects.size(); i++)
		{
			if (n.equals(object.get(i).getName()))
			{
				return true;
			}

			return false;
		}
	}

	Object getObject(String n)
	{
		for (int i = 0; i < objects.size(); i++)
		{
			if (n.equals(object.get(i).getName()))
			{
				return object.get(i);
			}
		}

		//If the object is not found in the scene, throw an exception
		throw new Exception(n + " was not found in scene " + this.name);
	}

	void takeObject(Object o)
	{
		int i = objects.indexOf(o);
		if (i >= 0)
		{
			object.remove(i);
		}
		else
		{
			//If the object is not found in the scene, throw an exception
            throw new Exception(o.getName() + " was not found in scene " + this.name);
        }
}