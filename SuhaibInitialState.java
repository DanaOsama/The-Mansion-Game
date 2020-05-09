import java.util.Random;
public class SuhaibInitialState implements SuhaibState {
	String[] lines = {"I really need some water, some water please.", "I would love to talk, but I am very thirsty. Get me some water please?", "Please just get me some water first, then I will talk.", "I AM DYING OF THIRST JUST GET ME SOME WATER."};
	public void prev(Suhaib s)
	{
		//Do nothing, you can't do anything
	}

	public void next(Suhaib s)
	{
		s.setState(new SuhaibFinalState());
	}

	public String printStatus() {
		return this.lines[new Random().nextInt(this.lines.length)];
	}
}
