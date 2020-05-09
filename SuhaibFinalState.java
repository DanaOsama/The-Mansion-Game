import java.util.Random;
public class SuhaibFinalState implements SuhaibState {
	String[] lines = {"Hey there!", "How you doin'!", "I like computers.", "This chair is not comfortable."};
	public void prev(Suhaib s)
	{
		s.setState(new SuhaibInitialState());
	}

	public void next(Suhaib s)
	{
		//Do nothing, you cant go next
	}

	public String printStatus() {
		return this.lines[new Random().nextInt(this.lines.length)];
	}
}
