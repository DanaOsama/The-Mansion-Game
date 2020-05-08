public class HappySuhaib extends Happy{

	public void prev(Mood m) throws Exception {
		System.out.println("How many times shall I introduce myself? It's Suhaib, a computer engineer");
		throw new Exception("Invalid request since you know who I am...");
	}

	public void next(Mood m) {
		m.setMood(new StressedSuhaib());
	}

}
