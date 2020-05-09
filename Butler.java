//singleton
class Butler extends Character{

	boolean[] Keys = {false, false, false};
	private static Butler instance = null;
	private ButlerState state = new ButlerInitialState();
	//MainRoomKeyObject?
	
	
	private Butler() {
		// SET SCENE FOR BUTLER
		super("Butler");
	}
	
	public void run() {
		while(true) {

			 
		}
	}
	
	public static Butler getInstance() {
		if (instance == null) {
			instance = new Butler();
		}
		return instance;
	}
	
	public void prevState() {
		state.prev(this);
	}
	
	public void nextState() {
		state.next(this);
	}
	
	public void printStatus() {
		state.printStatus();
	}
	
	public void setState(ButlerState state) {
		this.state = state;
	}
	
	public void giveKey(int keyNum) {
		
		if(Keys[keyNum-1]) {
			System.out.println("You have already presented me with key " + keyNum + ", "
					+ "please report back when you've key " +(keyNum+1)+ " in your possesion.");
		} else {
			Keys[keyNum-1] = true;
			nextState();
			printStatus();
		}
		
	}
	
	public void getMainRoomKey() {
		if (Keys[2] == true) {
			System.out.println("Yes ");
			//return MainRoomKeyObjectVar;
		} else {
			System.out.println("You need to collect all three keys to get the Main Room key! ");
		}
		
	}

	
	void delay(int ms)
	{
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}