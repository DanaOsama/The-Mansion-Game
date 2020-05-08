public class IntroduceSuhaib implements State {

	public void prev(Mood m) throws Exception {
		System.out.println("Why would you want me to go to my previous mood? :)");
		throw new Exception("Invalid request since I am not trapped anymore...");
	}

	public void next(Mood m) {
		m.setMood(new HappySuhaib());
	}

	public void printStatus() {
		System.out.println("Whew! I thought I'd die in there! Take this useless key...Stupid digital doors!");
		System.out.println("Where are my manners :) My name is Suhaib, a computer engineer.. Ironic right?");
		System.out.println("You'll see me around in different rooms, always ready to help :')");
	}

}
