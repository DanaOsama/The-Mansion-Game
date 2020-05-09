public class GoldenKey extends Object {
	public GoldenKey(Scene s, String n, String d)
	{
		super(s, n, d);
	}

	@Override
	public String take(Player p)
	{
		if (p.findObject("golden key"))
		{
			return cc.RED + "You can only carry one golden key at a time. Please give the butler this key." + cc.RESET;
		}
		else
		{
			p.addObject(this, "A golden key. You should give this to the butler at the Main Entrance.");
			try
			{
				this.currentScene.takeObject(this);
			} catch (Exception e) { e.printStackTrace(); }
			return cc.GREEN + "You got a golden key!" + cc.RESET;
		}
	}
}