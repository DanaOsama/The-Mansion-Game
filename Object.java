abstract public class Object {
	protected Scene currentScene;
	protected String name;

	//Constructor
	public Object(Scene s, String n)
	{
        this.currentScene = s;
        this.name = n;
	}

	//Setters
	public void setScene(Scene s)
	{
        
		this.currentScene = s;
	}

	//Getters
	public String getName()
	{
		return this.name;
	}
	
	//Commands
	void use()
	{
		System.out.println(this.name + " cannot be used!");
	}

	//Standard take command
	void take(Player p)
	{
		p.takeObject(this);
    }
    
    void read()
    {
        System.out.println(this.name + " cannot be read!");
    }
}