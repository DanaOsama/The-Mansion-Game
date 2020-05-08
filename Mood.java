//Context
public class Mood {
	private State mood;
	
	boolean PlayerInRoom;
	boolean Free = false;
	
	Mood(Suhaib s)
	{
		mood = new SuhaibInitialMood();
	}
	
	Mood(Butler b)
	{
		mood = new ButlerInitialMood();
	}
	
	public synchronized void setMood(State mood)
	{
		this.mood = mood;
	}
	
	public synchronized void prevState() throws Exception {
		mood.prev(this);
	}
	
	public synchronized void nextState() {
		mood.next(this);
	}
	
	public synchronized void printStatus() {
		mood.printStatus();
	}
}
