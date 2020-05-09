public class BackyardScene extends Scene {
    protected static BackyardScene instance;
    private BackyardScene(String n, UserInterface ui, Ticker t)
    {
        super(n, ui, t);
    }

    //implementing the Singleton design pattern.
    //We can only have one instance of Backyard
    public static synchronized BackyardScene getInstance(String n, UserInterface ui, Ticker t)
    {
        if (instance == null)
        {
            instance = new BackyardScene(n, ui, t);
            instance.loadObjects();
        }
        return instance;
	}

	public void loadObjects()
	{
		this.addObject(new ShovelObject(this, "shovel", "Leaning on one of the walls, there is a shovel."));
    }

    @Override
    public void goSouth(Player p)
    {
        //Change the scene to the main room
       this.notifyObservers(this.changeScene(this.south, p));
    }

    public String getMoveDescription()
    {
        return "You open the back door and step into the backyard.";
    }

	protected void describeSelf()
    {
        this.notifyObservers(cc.WHITE_BOLD + "The backyard is bounded by high walls. There is a field of dead dandelions on the left. Looks like someone was trying to bury something there." + cc.RESET);
    }
}