import java.util.Random;
//Strategy
public abstract class Angry implements State {

	public abstract void prev(Mood m) throws Exception;
	
	public abstract void next(Mood m);

	//Common for Suhaib and Butler
	public void printStatus() {
		String [] sentences = {"We are still here because of you!", "GET OUT OF MY FACE!!", "Not scaring you or anything, but I could literally murder you...", "I AM DONE WITH YOUR SLOWNESS!"};
		Random r = new Random();
		System.out.println(sentences[r.nextInt(4)]);
	}

}
