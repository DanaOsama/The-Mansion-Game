abstract public class SceneBehavior {
	protected Scene currentScene;
	public SceneBehavior(Scene s)
	{
		this.currentScene = s;
	}
	abstract public String doBehavior();
}