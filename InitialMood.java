//strategy
public abstract class InitialMood implements State {

	//Common for Suhaib and Butler
	public void prev(Mood m) {
		// TODO Auto-generated method stub
		System.out.println("How can I go to my previous mood if this is my initial??");
	}

	//Unique to Suhaib and Butler
	public abstract void next(Mood m);

	//Unique to Suhaib and Butler
	public abstract String printStatus();
}
