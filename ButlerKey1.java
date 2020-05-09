import java.util.Random;
public class ButlerKey1 implements ButlerState {
	String[] lines = {"Two more keys are what you need to be free.", "Can you help the poor man in the Dining Room?", "I remember something about a bucket in the Supply Room?"};
	public void prev(Butler b) {
		b.setState(new ButlerInitialState());
	}

	public void next(Butler b) {
		if (b.Keys[1]) b.setState(new ButlerKey2());
	}

	public String printStatus() {
		return this.lines[new Random().nextInt(this.lines.length)];
	}
}
