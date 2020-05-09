public class AxeObject extends Object {
	public AxeObject(Scene s, String n, String d)
	{
		super(s, n, d);
	}

	@Override
	public String take(Player p)
	{
		p.addObject(this, "An axe. Could be great for tearing down a closed door.");
		return cc.BLUE + "shovel has been added to your inventory." + cc.RESET;
	}

	@Override
	public String use(Player p)
	{
		return "Bruh momento!";
	}
}