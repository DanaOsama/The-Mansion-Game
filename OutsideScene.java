public class OutsideScene extends Scene {
    protected static OutsideScene instance;
    protected SceneBehavior behavior = new LockedSceneBehavior(this, "The door to your freedom won't open unless you get all three keys.");
    private OutsideScene(String n, UserInterface ui, Ticker t)
    {
        super(n, ui, t);
    }

    //implementing the Singleton design pattern.
    //We can only have one instance of OutsideScene
    public static synchronized OutsideScene getInstance(String n, UserInterface ui, Ticker t)
    {
        if (instance == null)
        {
            instance = new OutsideScene(n, ui, t);
            instance.loadObjects();
        }
        return instance;
    }

    @Override
    public void setBehavior(SceneBehavior b)
    {
        this.behavior = b;
    }

    @Override
    public void sceneBehavior()
    {
        this.notifyObservers(this.behavior.doBehavior());
    }

	public void loadObjects(){};

    public String getMoveDescription()
    {
        notifyObservers(cc.GREEN_BOLD + "With tired hands you open the now unlocked main door and step outside. This is it, you are free. You Win." + cc.RESET);
        System.exit(0);
        return "";
    }

	protected void describeSelf(){};
}