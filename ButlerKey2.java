import java.util.Random;
public class ButlerKey2 implements ButlerState {
	String[] lines = {"The final key. That is all that remains.", "The flower in the Dining Room only blooms at night. But beware of ghosts.", "The chest in this room will need a petal from a very special flower."};
	public void prev(Butler b) {
		b.setState(new ButlerKey1());
	}

	public void next(Butler b) {
		if (b.Keys[2]) b.setState(new ButlerKey3());
	}

	public String printStatus() {
		return this.lines[new Random().nextInt(this.lines.length)];
	}

}