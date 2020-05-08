
public class StressedSuhaib extends Stressed {

	public void prev(Mood m) throws Exception {
		System.out.println("Ah...I'll take the chill pill indeed...");
		m.setMood(new HappySuhaib());
	}

	public void next(Mood m) {
		m.setMood(new AngrySuhaib());
	}

}
