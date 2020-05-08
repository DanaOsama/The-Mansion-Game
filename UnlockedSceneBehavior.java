public class UnlockedSceneBehavior extends SceneBehavior {
	private Player player;
	public UnlockedSceneBehavior(Scene s, Player p)
	{
		super(s);
		this.player = p;
	}

	public String doBehavior()
	{
		return this.currentScene.changeScene(this.currentScene, this.player);
	}
}