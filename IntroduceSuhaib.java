public class IntroduceSuhaib implements State {

	public void prev(Mood m) throws Exception {
		System.out.println("Why would you want me to go to my previous mood? :)");
		throw new Exception("Invalid request since I am not trapped anymore...");
	}

	public void next(Mood m) {
		if (m.PlayerInRoom) m.setMood(new HappySuhaib());
		else System.out.println("You left me alone :(");
	}

	public void printStatus() {
		System.out.println("Whew! I thought I'd die in there! Stupid digital doors!");
		System.out.println("Where are my manners :) My name is Suhaib, a computer engineer.. Ironic right?");
	}

}
