//context class in states
abstract public class Character implements Runnable{
	protected Scene currentScene;
	protected String name;
	Mood m;

	public Character(Scene currentScene, String name) {
		Thread t = new Thread();
		this.currentScene = currentScene;
		this.name = name;
		t.start();
	}

	public abstract void run();
}
