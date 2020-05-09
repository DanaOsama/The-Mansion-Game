public class BucketObject extends Object implements Observer {
	private int numTicks = 0;
	private boolean isFull = false;
	public BucketObject(Scene s, String n, String d)
	{
		super(s, n, d);
		this.currentScene.getTicker().registerObserver(this);
	}

	public void update()
	{
		this.numTicks++;

		//300 seconds need to pass
		if (this.numTicks >= 300)
		{
			this.isFull = true;

			//No need to listen to time now
			this.currentScene.getTicker().removeObserver(this);
		}
	}
}