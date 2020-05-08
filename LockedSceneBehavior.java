public class LockedSceneBehavior extends SceneBehavior {
	private String reason;
	public LockedSceneBehavior(Scene s, String r)
	{
		super(s);
		this.reason = r;
	}

	public String doBehavior()
	{
		return this.reason;
	}
}