public class MainEntranceScene extends Scene {
    protected static MainEntranceScene instance;
    protected SceneBehavior behavior = new LockedSceneBehavior(this, "You push against the door but it does not budge. Does it need a key to be unlocked?");
    private MainEntranceScene(String n, UserInterface ui, Ticker t)
    {
        super(n,ui,t);
    }

    //implementing the Singleton design pattern.
    //We can only have one instance of Main Entrance
    public static synchronized MainEntranceScene getInstance(String n, UserInterface ui, Ticker t)
    {
        if (instance == null)
        {
            instance = new MainEntranceScene(n, ui, t);
            instance.loadObjects();
        }
        return instance;
    }

	public void loadObjects()
	{
        this.addObject(new ClockObject(this, "watch", "On a small table, there is a watch."));
        this.addObject(new AppleObject(this, "apple", "In a small basket on the ground, there is a red apple.", 180));
        this.addObject(new ChestObject(this, "chest", "In the corner on a large desk, lies a small chest with symbol of a moon and a flower etched into it."));
    }

    public void setBehavior(SceneBehavior b)
    {
        this.behavior = b;
    }

    @Override
    public void sceneBehavior()
    {
        this.notifyObservers(this.behavior.doBehavior());
    }

    @Override
    public void goEast(Player p)
    {
        //Also activate suhaib
        try {

            this.east.getCharacter("suhaib").setActivated(true);
        } catch (Exception e) { e.printStackTrace(); }
        this.east.sceneBehavior();
    }

    @Override
    public void goWest(Player p)
    {
        this.notifyObservers(this.changeScene(this.west, p));
    }

    @Override
    public void goNorth(Player p)
    {
        //Change the scene to the main room
       this.notifyObservers(this.changeScene(this.north, p));
    }

    @Override
    public void goSouth(Player p)
    {
        this.south.sceneBehavior();
    }

    public String getMoveDescription()
    {
        return "You push against the door and enter the main entrance.";
    }

	protected void describeSelf()
    {
        this.notifyObservers(cc.WHITE_BOLD + "The main entrance is a dimly lit, large room with dusty maroon carpets. There are low hanging chandeliers and a large oak door with, peculiarly, 3 keyholes." + cc.RESET);
    }
}
