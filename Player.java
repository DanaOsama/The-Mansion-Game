import java.util.ArrayList;
public class Player implements Runnable{
    private static Player instance;
	private ArrayList<Object> inventory = new ArrayList<Object>();
    private Output out;
    private String name;
    private Scene currentScene;

    private Player(String n, Output o, Scene s)
    {
        this.name = n;
        this.out = o;
        this.currentScene = s;
    }
    
    //Singleton design pattern
    synchronized public static Player getInstance(String n, Output o, Scene s)
    {
        if(instance == null)
        {
            instance = new Player(n, o, s);
            return instance;
        }
        else
        {
            return instance;
        }
    }

    // Setters
    public void setScene(Scene s)
    {
        this.currentScene = s;
    }

    // Getters
    public String getName()
    {
        return this.name;
    }

    public void run()
    {
        while (true)
        {
            //do nothing?? lmao
        }
    }

    //Inventory functions
    public void takeItem(Object obj, String d)
    {
        try 
        {
            //Take it from the scene
            obj.setSceneDescription(d);
            inventory.add(obj);

            //Remove it from the scene
            currentScene.takeObject(obj);

            //Print statement :)
            out.println(obj.getName() + " has been added to your inventory.");

        } catch(Exception e) {e.printStackTrace();}
    }

    public void listInventory()
    {
        if (inventory.size() == 0)
        {
            out.println("There is nothing in your inventory.");
        }
        else
        {
            out.println("~ Inventory ~");
            for (int i = 0; i < inventory.size(); i++)
            {
                out.println(" - " + inventory.get(i).getName());
            }
        }
    }

    void addObject(Object obj, String d)
	{
        obj.setSceneDescription(d);
		inventory.add(obj);
    }
    
    Object getObject(String n) throws Exception
	{
		for (int i = 0; i < inventory.size(); i++)
		{
			if (n.equals(inventory.get(i).getName()))
			{
				return inventory.get(i);
			}
		}

		//If the object is not found in the scene, throw an exception
		throw new Exception(n + " was not found in inventory " + this.name);
    }
    
    boolean findObject(String n)
	{
		for (int i = 0; i < inventory.size(); i++)
		{
			if (n.equals(inventory.get(i).getName()))
			{
				return true;
			}
		}
		return false;
	}
}