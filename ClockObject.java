public class ClockObject extends Object {
    private Ticker tick;
    public ClockObject(Scene s, String n, String d)
    {
        super(s, n, d);
        this.tick = s.getTicker();
    }

    @Override
    public String take(Player p)
    {
        p.takeItem(this, "A pocket watch. Maybe it can be used to tell the time?");
        return (this.getName() + " has been added to your inventory.");
    }

    @Override
    public String use(Player p)
    {
        //When the object is used, we can now tell the player the number of seconds left
        return "You look at the pocket watch. It tells you there are " + (300 - this.tick.stateTicks()) + " seconds left till " + ((this.tick.getState() == 0) ? "night" : "morning");
    }
}