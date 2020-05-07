
//diff inital moods for each Character 
// strategy design
abstract class InitialMood implements State { 

	@Override
	public void prev(Object o) {
		// TODO Auto-generated method stub
		System.out.println("Initial stage.");
	}

	@Override
	public abstract boolean next(Object o);

	@Override
	public abstract void printStatus();
	
}

class ButlerInitalMood extends InitialMood {

	@Override
	public boolean next(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void printStatus() {
		// TODO Auto-generated method stub
		
	}
	
}

class SuhaibInitalMood extends InitialMood {

	@Override
	public boolean next(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void printStatus() {
		// TODO Auto-generated method stub
		
	}
	
}

abstract public class Character { //context
	protected Scene currentScene;
	protected String name;
	InitialMood iM;
	State mood;
	
	public Character(Scene currentScene, String name, InitalMood iM) {
		super();
		this.currentScene = currentScene;
		this.name = name;
		this.iM = iM;
		mood = new InitialMood(); // has to be dynamic
	}

	public void prevState() {
		mood.prev(this);
	}
	
	public void nextState() {
		mood.next(this);
	}
	
	public void printStatus() {
		mood.printStatus();
	}
	
	public void setState(State state) {
		this.mood = state;
	}
	
}
