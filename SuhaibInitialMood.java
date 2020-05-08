//strategy
class SuhaibInitialMood extends InitialMood {
	
	public void next(Mood m) {
		m.setMood(new HelpSuhaib());
	}

	public void printStatus() {
		System.out.println("HELP! HELP! You need to figure out the combination on the door to free me!");
	}
	
}
