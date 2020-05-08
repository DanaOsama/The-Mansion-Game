class ButlerInitalMood extends InitialMood {

	public void next(Mood m) {
		if (keys[0]) 
			m.setMood(new RandomButler());
	}

	public void printStatus() {
		System.out.println("Mentions the task of the player?? :')");
	}
	
}
