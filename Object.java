abstract public class Object {
	protected Scene currentScene;
	protected String name;
	protected String objectSceneDescription;
	protected UserInterface ui;

	//Constructor
	public Object(Scene s, String n, String d)
	{
        this.currentScene = s;
		this.name = n;
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
	//Returns the name of the scene the object is currently in
	public String getSceneName()
	{
		return this.currentScene.getName();
	}

	//Commands
	public String inspect()
	{
		return this.getSceneDescription();
	}

	//to use an object, it should be in the player's inventory
	public String use(Player p)
	{
		return (this.name + " cannot be used!");
	}

	//Standard take command
	public String take(Player p)
	{
		return (this.name + " cannot be taken!");
	}

   public String read()
    {
        return (this.name + " cannot be read!");
	}

	public String eat(Player p)
	{
		return(this.name + " cannot be eaten!");
	}
}