import java.util.Random;
public class ButlerKey3 implements ButlerState {
	String[] lines = {"That is it, the door is unlocked.", "Congratulations, my friend. You have opened the door.", "I hope I do not see you in this place again.", "It seems you have escaped your unfortunate fate."};
	public void prev(Butler b) {
		b.setState(new ButlerKey2());
	}

	public void next(Butler b) {
		return; //Do nothing.
	}

	public String printStatus() {
		return this.lines[new Random().nextInt(this.lines.length)];
	}
}