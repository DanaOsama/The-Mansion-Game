public class DiningRoomScene extends Scene {
    protected static DiningRoomScene instance;
    protected SceneBehavior behavior = new LockedSceneBehavior(this, "The door seems to be boarded up and must be torn down. Kicking it does not help.");
    private DiningRoomScene(String n, UserInterface ui, Ticker t)
    {
        super(n, ui, t);
    }

    //implementing the Singleton design pattern.
    //We can only have one instance of Backyard
    public static synchronized DiningRoomScene getInstance(String n, UserInterface ui, Ticker t)
    {
        if (instance == null)
        {
            instance = new DiningRoomScene(n, ui, t);
            instance.loadObjects();
        }
        return instance;
	}

	public void loadObjects()
	{
        this.addObject(new MoonFlowerObject(this, "flower", "On the dining table is a huge Moon Flower plant. It is eerily glowing lilac. It's petals are closed."));
    }

    @Override
    public void setBehavior(SceneBehavior s)
    {
        this.behavior = s;
    }

    @Override
    public void sceneBehavior()
    {
        this.notifyObservers(this.behavior.doBehavior());
    }

    @Override
    public void goWest(Player p)
    {
        //Change the scene to the main room
       this.notifyObservers(this.changeScene(this.west, p));
    }

    public String getMoveDescription()
    {
        return "You walk through what used to be a door and into the dining room.";
    }

    //TODO: Write a proper description for the dining room
	protected void describeSelf()
    {
        this.notifyObservers(cc.WHITE_BOLD + "The dining room is a long room with a big mahogony table in the dead-center. A hearth lies there with a kindling fire, basking the room in a redish glow." + cc.RESET);
    }
}