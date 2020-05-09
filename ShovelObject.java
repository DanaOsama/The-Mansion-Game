public class ShovelObject extends Object {
	public ShovelObject(Scene s, String n, String d)
	{
		super(s, n, d);
	}

	@Override
	public String take(Player p)
	{
		p.addObject(this, "A shovel. Maybe it can be used to dig something up?");
		try
		{
			this.currentScene.takeObject(this);
		} catch(Exception e) {e.printStackTrace(); return e.toString();}
		return cc.BLUE + "shovel has been added to your inventory." + cc.RESET;
	}

	@Override
	public String use(Player p)
	{
		if (this.getSceneName().equals("Backyard"))
		{
			this.currentScene.addObject(new AxeObject(this.currentScene, "axe", "On the ground lies a dirty axe."));
			this.currentScene.addObject(new GoldenKey(this.currentScene, "golden key", "Laying in a now uncovered hole, there is a golden key."));
			p.removeObject(this);
			return cc.GREEN + "Using the shovel, you dig up some holes in the ground and uncover some items." + cc.RESET;
		}
		else
		{
			return cc.RED + "I don't see how this can be used here." + cc.RESET;
		}
	}
}