public class SupplyRoomScene extends Scene {
    protected static SupplyRoomScene instance;

    //Supply room is the first scene , therefore we manually pass it player.
    private SupplyRoomScene(String n, UserInterface ui, Ticker t)
    {
        super(n,ui,t);
    }

    //implementing the Singleton design pattern.
    //We can only have one instance of Supply Room
    public static synchronized SupplyRoomScene getInstance(String n, UserInterface ui, Ticker t)
    {
        if (instance == null)
        {
            instance = new SupplyRoomScene(n, ui, t);
            instance.loadObjects();
        }
        return instance;
    }

    @Override
    public void goEast(Player p)
    {
        //Change the scene to the main room
        this.east.sceneBehavior();
    }

    protected void loadObjects()
    {
        //Creating objects in the scene
        NoteObject noteSupplyRoom = new NoteObject(instance, "old note", "WELCOME MESSAGE HERE", "There is an old note lying on the floor.");
        BucketObject bucket = new BucketObject(instance, "bucket", "In the corner, there is a bucket overflowing with the water dripping from the ceiling.");
        BookObject bookSupplyRoom = new BookObject(instance, "book", "On a shelf lies a book suspiciously out of place.");

        //Adding the object to the scene
        this.addObject(noteSupplyRoom);
        this.addObject(bucket);
        this.addObject(bookSupplyRoom);
    }

    public String getMoveDescription()
    {
        return "You push against a small metal door and enter the supply room.";
    }

    protected void describeSelf()
    {
        this.notifyObservers(cc.WHITE_BOLD + "It looks like you are in a supply room of some sorts. There are things littered everywhere. The sound of water dripping can be heard nearby." + cc.RESET);
    }
}