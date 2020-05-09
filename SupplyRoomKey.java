public class SupplyRoomKey extends Object {
    public SupplyRoomKey(Scene s, String n, String d)
    {
        super(s, n, d);
    }

    @Override
    public String take(Player p)
    {
        p.takeItem(this, "A black key. Maybe this can open one of the doors?");
        return (this.cc.BLUE + this.getName() + " has been added to your inventory." + cc.RESET);
    }

    @Override
    public String use(Player p)
    {
        if (this.getSceneName().equals("Supply Room"))
        {
            try{
                Object temp = p.getObject(this.getName());
                this.currentScene.east.setBehavior(new UnlockedSceneBehavior(this.currentScene.east, p));
                p.removeObject(temp);
                return this.cc.GREEN + "You unlocked the door to the main entrance." + this.cc.RESET;
                //Change state of main entrance to unlocked :)
            }catch(Exception e){return "Object not found!";}
        }
        else
        {
            return(this.cc.RED + "I don't see how " + this.getName() + " can be used in this room." + this.cc.RESET);
        }
    }
}