public class AppleObject extends Object implements Observer {
	private int timeTillExpire;
	private int timePassed = 0;
	boolean isRotten = false;
	public AppleObject(Scene s, String n, String d, int t)
	{
		super(s, n, d);
		this.timeTillExpire = t;
		this.currentScene.getTicker().registerObserver(this);
	}

	@Override
	public String eat(Player p)
	{
		if (this.isRotten)
		{
			p.hurt(cc.RED + "You bite into the apple but immediately spit it out in disgust. It is rotten!" + cc.RESET);
			try {
				this.currentScene.takeObject(this);
				return "You throw the apple away.";
			} catch (Exception e) { e.printStackTrace(); return e.toString();}
		}
		else
		{
			p.heal(cc.GREEN + "You bite into the apple and it's taste fills your mouth. Delicious!" + cc.RESET);
			try {
				this.currentScene.takeObject(this);
				return "You finish eating the apple.";
			} catch (Exception e) { e.printStackTrace(); return e.toString();}
		}
	}

	@Override
	public String take(Player p)
	{
		//Logic check, if the player already has an apple replace it
		if (p.findObject("apple"))
		{
			try
			{
				p.removeObject(p.getObject("apple"));
			} catch (Exception e) { return e.toString(); }
		}
		if (this.isRotten)
		{
			p.addObject(this, "An apple. Eating it heals you a heart! This one might be rotten though.");
		}
		else
		{
			p.addObject(this, "An apple. Eating it heals you a heart!");
		}
		return cc.BLUE + "apple has been added to your inventory." + cc.RESET;
	}

	public void update()
	{
		this.timePassed++;
		if (this.timePassed >= this.timeTillExpire)
		{
			//No need to be subscribed to time anymore
			this.currentScene.getTicker().removeObserver(this);
			this.isRotten = true;
			this.objectSceneDescription += " This apple might be rotten now, though.";
		}
	}
}