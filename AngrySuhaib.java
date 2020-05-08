public class AngrySuhaib extends Angry{

	public void prev(Mood m) throws Exception {
		m.setMood(new StressedSuhaib());
	}

	public void next(Mood m) {
		m.setMood(new HappySuhaib());
	}

}
