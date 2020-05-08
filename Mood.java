//Context
public class Mood {
	private State mood;
	
	public void setMood(State mood)
	{
		this.mood = mood;
	}
	
	public void prevState() throws Exception {
		mood.prev(this);
	}
	
	public void nextState() {
		mood.next(this);
	}
	
	public void printStatus() {
		mood.printStatus();
	}
}
