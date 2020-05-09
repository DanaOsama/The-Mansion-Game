public class AxeObject extends Object {
	public AxeObject(Scene s, String n, String d)
	{
		super(s, n, d);
	}

	@Override
	public String take(Player p)
	{
		p.addObject(this, "An axe. Could be great for tearing down a closed door.");
		try
		{
			this.currentScene.takeObject(this);
		} catch (Exception e) { e.printStackTrace(); }
		return cc.BLUE + "shovel has been added to your inventory." + cc.RESET;
	}

	@Override
	public String use(Player p)
	{
		if (p.getCurrentScene().getName().equals("Main Entrance"))
		{
			//First we unlock the Dining Room
			this.currentScene.east.setBehavior(new UnlockedSceneBehavior(this.currentScene.east, p));

			try
			{
				//Then we tell suhaib he was freed
				this.currentScene.east.getCharacter("suhaib").setFreed(true);

				//Now let's destroy the axe
				p.removeObject(this);

				return cc.GREEN + "You cut down the Dining Room door until there's nothing left. Well, at least now you can go inside." + cc.RESET;
			} catch (Exception e) { e.printStackTrace(); return e.toString(); }

		}
		else
		{
			return cc.RED + "I don't see how this can be used here." + cc.RESET;
		}
	}
}