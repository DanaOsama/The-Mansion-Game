import java.util.Random;

public class HelpSuhaib implements State {

	public void prev(Mood m) {
		System.out.println("Why would you want me to go to my previous mood? :)");
		m.setMood(new SuhaibInitialMood());
	}

	public void next(Mood m) {
		m.setMood(new IntroduceSuhaib());
	}

	public void printStatus() {
		String [] sentences = {"HELP! HELP!", "SOS! WHERE'S 911 WHEN WE NEED THEM?!", "STUPID FEMALES GOT ME HERE :)"};
		Random r = new Random();
		System.out.println(sentences[r.nextInt(3)]);
	}

}
