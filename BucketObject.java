public class BucketObject extends Object implements Observer {
	private int numTicks = 0;
	private boolean isFull = false;
	public BucketObject(Scene s, String n, String d)
	{
		super(s, n, d);
		this.currentScene.getTicker().registerObserver(this);
	}

	@Override
	public String take(Player p)
	{
		if (this.isFull)
		{
			p.takeItem(this, "A bucket filled with water. Maybe someone can drink this?");
			return cc.GREEN + "You take the bucket filled with water and add it to your inventory." + cc.RESET;
		}
		else
		{
			return cc.RED + "Why would I take this right now? It is empty. I should at least wait until it fills up." + cc.RESET;
		}
	}

	public void update()
	{
		this.numTicks++;

		//300 seconds need to pass
		if (this.numTicks >= 300)
		{
			this.isFull = true;
			this.setSceneDescription("In the corner, there is a bucket now filled with water dripping from the ceiling.");
			//No need to listen to time now
			this.currentScene.getTicker().removeObserver(this);
		}
	}
}