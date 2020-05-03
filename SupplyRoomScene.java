public class SupplyRoomScene extends Scene implements Runnable {
    protected static SupplyRoomScene instance;

    private SupplyRoomScene(String n, Output o, Ticker t)
    {
        super(n, o, t);
    }

    //implementing the Singleton design pattern.
    //We can only have one instance of Supply Room
    public static synchronized SupplyRoomScene getInstance(String n, Output o, Ticker t)
    {
        if (instance == null)
        {
            instance = new SupplyRoomScene(n, o, t);
        }
        return instance;
    }
    
    protected void loadObjects()
    {
        //Creating objects in the scene
        NoteObject noteSupplyRoom = new NoteObject(instance, "old note", "WELCOME MESSAGE HERE", out, "There is an old note lying on the floor.");
        BucketObject bucket = new BucketObject(instance, "bucket", out, "In the corner, there is a bucket overflowing with the water dripping from the ceiling.");
        BookObject bookSupplyRoom = new BookObject(instance, "book", out ,"On a shelf lies a book suspiciously out of place.");    

        //Adding the object to the scene
        this.addObject(noteSupplyRoom);
        this.addObject(bucket);    
        this.addObject(bookSupplyRoom);
    }

    protected void describeSelf()
    {
        out.print(" It looks like you are in a supply room of some sorts. There are things literred everywhere. The sound of water dripping can be heard nearby.");
    }

    public void run()
    {
        this.loadObjects();
        while (true)
        {
            //do nothing
        }
    }
}