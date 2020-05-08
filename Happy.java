import java.util.Random;

//Strategy
public abstract class Happy implements State {

	
	public abstract void prev(Mood m) throws Exception;

	public abstract void next(Mood m);

	//Common for Suhaib and Butler
	public void printStatus() {
		String [] sentences = {"It's good to be alive.", "I believe I can flyy...I believe I can touch the skyyy!!", "Don't forget to drink your milk kids ;)", "If you're happy and you know it clap your hands!!"};
		Random r = new Random();
		System.out.println(sentences[r.nextInt(4)]);
	}

}
