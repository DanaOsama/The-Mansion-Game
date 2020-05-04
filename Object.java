abstract public class Object {
	protected Scene currentScene;
	protected String name;
	protected String objectSceneDescription;
	protected Output out;

	//Constructor
	public Object(Scene s, String n, Output o, String d)
	{
        this.currentScene = s;
		this.name = n;
		this.out = o;
		this.objectSceneDescription = d;
	}

	//Setters
	public void setScene(Scene s)
	{
		this.currentScene = s;
	}

	public void setSceneDescription(String s)
	{
		this.objectSceneDescription = s;
	}

	//Getters
	public String getName()
	{
		return this.name;
	}

	public String getSceneDescription()
	{
		return this.objectSceneDescription;
	}

	//Commands
	public void inspect()
	{
		out.println(this.getSceneDescription());
	}

	public void use()
	{
		out.println(this.name + " cannot be used!");
	}

	//Standard take command
	public void take(Player p)
	{
		out.println(this.name + " cannot be taken!");
    }
    
   public void read()
    {
        out.println(this.name + " cannot be read!");
	}
}