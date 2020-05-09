public class SupplyRoomKey extends Object {
    public SupplyRoomKey(Scene s, String n, String d)
    {
        super(s, n, d);
    }

    @Override
    public String take(Player p)
    {
        p.takeItem(this, "A black key. Maybe this can open one of the doors?");
        return (this.cc.BLUE + "key has been added to your inventory." + cc.RESET);
    }

    @Override
    public String use(Player p)
    {
        if (this.getSceneName().equals("Supply Room"))
        {
            try{
                p.removeObject(p.getObject("key"));
                this.currentScene.east.setBehavior(new UnlockedSceneBehavior(this.currentScene.east, p));
                return this.cc.GREEN + "You unlocked the door to the main entrance." + this.cc.RESET;
                //Change state of main entrance to unlocked :)
            }catch(Exception e){e.printStackTrace(); return "Object not found!";}
        }
        else
        {
            return(this.cc.RED + "I don't see how this can be used in this room." + this.cc.RESET);
        }
    }
}