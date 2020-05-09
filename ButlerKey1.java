
public class ButlerKey1 implements ButlerState {

	public void prev(Butler b) {
		b.setState(new ButlerInitialState());
	}
	
	public void next(Butler b) {
		if (b.Keys[1])	
			b.setState(new ButlerKey2());
	}

	public void printStatus() {
		System.out.println("Congratulations, you have found the first key. "
				+ "You now have to find the remaining 2 keys.");

	}

}
