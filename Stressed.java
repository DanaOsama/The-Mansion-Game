import java.util.Random;
//Strategy
public abstract class Stressed implements State {

	public abstract void prev(Mood m) throws Exception;
	
	public abstract void next(Mood m);

	//Common for Suhaib and Butler
	public void printStatus() {
		String [] sentences = {"Seconds are minutes turning into hours! What's going on??", "Will we get out of here? Wil I live to see my family??", "That's it we are doomed! You are useless!", "I didn't even get to try that cheesecake I've been craving :("};
		Random r = new Random();
		System.out.println(sentences[r.nextInt(4)]);
	}

}
