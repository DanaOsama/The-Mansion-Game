//context class in states
abstract public class Character implements Runnable{
	protected Scene currentScene;
	protected String name;
	protected String sceneDescription;
	Mood m;

	public Character(Scene currentScene, String name, String s) {
		Thread t = new Thread(this);
		this.currentScene = currentScene;
		this.name = name;
		this.sceneDescription = s;
		t.start();
	}

	public String getName()
	{
		return this.name;
	}

	public String getSceneDescription()
	{
		return this.sceneDescription;
	}

	public abstract void run();
}
