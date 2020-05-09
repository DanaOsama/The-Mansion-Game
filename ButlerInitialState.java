
public class ButlerInitialState implements ButlerState {
	
	public void prev(Butler b) {
		System.out.println("This is the beginning. Find the 3 keys.");
	}
	
	public void next(Butler b) {
		if (b.Keys[0])	
			b.setState(new ButlerKey1());
	}

	public void printStatus() {
		System.out.println("Please find the 3 keys.");

	}

}
