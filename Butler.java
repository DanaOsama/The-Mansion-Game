 //singleton
public class Butler extends Character{

	Boolean[] Keys = {false, false, false, false, false};
	
	private Butler instance = null;
	
	private Butler() {
		// SET SCENE FOR BUTLER
		super(currentScene, "Butler");
		m = new ButlerInitialMood();
	}
	
	public void run() {
		
	}
	
	public Butler getInstance() {
		if (instance == null) {
			instance = new Butler();
		}
		return instance;
	}
	
	
	public void giveKey(int keyNum) {
		Keys.(keyNum-1) = true;
		System.out.println("You have successfully collected key number " + keyNum );
	}
	

}
