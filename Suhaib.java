//singleton
public class Suhaib extends Character {
	private static Suhaib instance = null;
	private SuhaibState state = new SuhaibInitialState();
	private boolean activated = false;
	private boolean freed = false;
	private boolean firstTimeTalking = true;
	private Suhaib(Scene currentScene, String d, Player p)
	{
		super(currentScene, "suhaib", d, p);
	}

	public void run()
	{
		while(true)
		{
			//See an explanation of why this happens in Player.java
			System.out.print("");
			try
			{
				if (this.activated && !this.freed)
				{
					notifyObservers(cc.YELLOW + "You hear Suhaib screaming: " + cc.RESET + cc.BLUE_BOLD + "'Help me! I am trapped inside the Dining Room!'" + cc.RESET);
					Thread.sleep(60000); //Every 60 seconds
				}
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}

	@Override
	public void setActivated(boolean b)
	{
		this.activated = b;
	}

	@Override
	public void setFreed(boolean b)
	{
		this.freed = b;
	}

	//Singleton Pattern
	public static Suhaib getInstance(Scene currentScene, String d, Player p) {
		if (instance == null) {
			instance = new Suhaib(currentScene, d, p);
		}
		return instance;
	}

	public void prevState() {
		state.prev(this);
	}

	public void nextState() {
		state.next(this);
	}

	public void setState(SuhaibState state) {
		this.state = state;
	}

	public String talkTo()
	{
		if (this.firstTimeTalking)
		{
			this.firstTimeTalking = false;
			return cc.YELLOW + "Suhaib says: " + cc.RESET + cc.BLUE_BOLD + "'Thanks for breaking down this door! I thought I was going to die! But I really could use some water right now. Can you get me some?'" + cc.RESET;
		}
		else
		{
			//If the player has water with them
			if (this.player.findObject("bucket"))
			{
				//Suhaib will now move to the next state and give the player the golden key + remove the bucket
				try
				{
					this.player.removeObject(this.player.getObject("bucket"));
				} catch (Exception e) { e.printStackTrace(); }

				//Give the player a golden key
				this.currentScene.addObject(new GoldenKey(this.currentScene, "golden key", "A golden key lies on the dining table next to Suhaib."));

				//Thank the player and move to the next state
				notifyObservers(cc.YELLOW + "Suhaib says: " + cc.RESET + cc.BLUE_BOLD + "'Thank you so much for the water. That was refreshing. Here you go, I found this golden key lying around. I'll just put it on the table." + cc.RESET);
				this.nextState();
				return cc.YELLOW + "Suhaib places a golden key on the table near him." + cc.RESET;
			}
			else
			{
				return this.state.printStatus();
			}
		}
	}
}
