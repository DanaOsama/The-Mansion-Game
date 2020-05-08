  
public class Butler extends Character{

	Boolean[] Keys = {false, false, false, false, false};
	
	public Butler(Scene currentScene, String name) {
		super(currentScene, name);
		m = new ButlerInitialMood();
	}
	
	public void run()
	{
		
	}

}
