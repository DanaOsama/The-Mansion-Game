//strategy
class SuhaibInitialMood extends InitialMood {
	
	public void next(Mood m) {
		if (m.PlayerInRoom) m.setMood(new HelpSuhaib());
		else System.out.println("You are not in the room!");
		}

	public void printStatus() {
		System.out.println("HELP! HELP! You need to figure out the combination on the door to free me!");
	}
	
}
