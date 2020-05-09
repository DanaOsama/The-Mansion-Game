
public class ButlerKey2 implements ButlerState {

	public void prev(Butler b) {
		b.setState(new ButlerKey1());
	}
	
	public void next(Butler b) {
		if (b.Keys[2])	
			b.setState(new ButlerKey3());	
	}

	public void printStatus() {
		System.out.println("Congratulations, you have found the second key. "
				+ "You now have to find the last remaining key to earn your freedom.");
	}
}
