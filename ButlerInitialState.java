import java.util.Random;
public class ButlerInitialState implements ButlerState {
	String[] lines = {"To escape, find a key then talk to me.", "The only way to escape is to give me a key.", "Want to leave? Give me golden keys. Exactly 3. No less.", "Have you been to the backyard? Wonderful weather today."};
	boolean firstTime = true;
	public void prev(Butler b) {
		System.out.println("This is the beginning. Find the 3 keys.");
	}

	public void next(Butler b) {
		if (b.Keys[0]) b.setState(new ButlerKey1());
	}

	public String printStatus() {
		if (this.firstTime)
		{
			this.firstTime = false;
			return "Welcome to the old house. I am The Butler. To escape this prison, you will have to find three golden keys and give them to me to open this door behind me. Good luck.";
		}
		else
		{
			return this.lines[new Random().nextInt(this.lines.length)];
		}
	}
}
