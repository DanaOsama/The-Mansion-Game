public class SupplyRoomKey extends Object {
    public SupplyRoomKey(Scene s, String n, Output o, String d)
    {
        super(s, n, o, d);
    }
    
    @Override
    public void take(Player p)
    {
        p.takeItem(this, "A black key. Maybe this can open one of the doors?");
    }
}