//singleton
class Butler extends Character {

	boolean[] Keys = {false, false, false};
	private int numKeys = 0;
	private static Butler instance = null;
	private ButlerState state = new ButlerInitialState();
	private boolean firstTimeTalking = true;
	private boolean playerHasNewKey = true;
	private Butler(Scene currentScene, String d, Player p)
	{
		super(currentScene, "butler", d, p);
	}

	public void run()
	{
		while(true)
		{
			System.out.print("");
			//Check if the player got a key
			for (int i = 0; i < this.player.getInventory().size(); i++)
			{
				if (this.player.getInventory().get(i) instanceof GoldenKey)
				{
					if (this.playerHasNewKey)
					{
						notifyObservers(cc.YELLOW + "You hear the butler calling to you: " + cc.RESET + cc.CYAN + "'I see you found a golden key! Come give it to me as soon as possible.'" + cc.RESET);
						this.playerHasNewKey = false;
					}
				}
			}
		}
	}

	//Singleton Pattern
	public static Butler getInstance(Scene currentScene, String d, Player p) {
		if (instance == null) {
			instance = new Butler(currentScene, d, p);
		}
		return instance;
	}

	public void prevState() {
		state.prev(this);
	}

	public void nextState() {
		state.next(this);
	}

	public void setState(ButlerState state) {
		this.state = state;
	}

	public void giveKey(int keyNum) {

		if(Keys[keyNum-1]) {
			notifyObservers("You have already presented me with key " + keyNum + ", " + "please report back when you have key " + (keyNum + 1) + " in your possession.");
		} else {
			Keys[keyNum-1] = true;
			nextState();
			// printStatus();
		}
	}

	public String talkTo()
	{
		if (this.firstTimeTalking)
		{
			this.firstTimeTalking = false;
			return cc.YELLOW + "The butler says: " + cc.RESET + cc.CYAN + "'" + state.printStatus() + "'" + cc.RESET;
		}
		else
		{
			//Check if the player has a golden key for us
			if (this.player.findObject("golden key"))
			{
				try {
					this.player.removeObject(this.player.getObject("golden key"));
				} catch (Exception e) { e.printStackTrace(); }
				this.playerHasNewKey = true;
				this.Keys[this.numKeys] = true;
				this.numKeys++;
				this.notifyObservers(cc.YELLOW + "The butler says: " + cc.RESET + cc.CYAN + "'I see you have a golden key, I will take that. You have given me " + this.numKeys + " keys so far. Keep going.'" + cc.RESET);
				this.state.next(this);
				if (this.numKeys < 3)
				{
					return cc.YELLOW + (3 - this.numKeys) + " keys left!" + cc.RESET;
				}
				else
				{
					this.currentScene.south.setBehavior(new UnlockedSceneBehavior(this.currentScene.south, this.player));
					return cc.GREEN + "All keys collected!" + cc.RESET + "\n" + cc.YELLOW + "The butler turns the three golden keys, and the door to the outside unlocks." + cc.RESET;
				}
			}
			else
			{
				return cc.YELLOW + "The butler says: " + cc.RESET + cc.CYAN + "'" + state.printStatus() + "'" + cc.RESET;
			}
		}
	}
}
