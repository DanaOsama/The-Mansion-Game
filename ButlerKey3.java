
public class ButlerKey3 implements ButlerState {

	public void prev(Butler b) {
		b.setState(new ButlerKey2());
	}
	
	public void next(Butler b) {
		System.out.println("Congratulations, you have successfully collected all three keys!");	
	}

	public void printStatus() {
		System.out.println("Congratulations, you have successfully collected all three keys!");

		}

}
