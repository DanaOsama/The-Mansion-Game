public class GoEastCommand implements Command {
	private Player player;

	public void setPlayer(Player p)
	{
		this.player = p;
	}

	public void setObject(Object o){};

	public String execute()
	{
		this.player.getCurrentScene().goEast(this.player);
		return "You head east.";
	}

	public String getHelp()
	{
		return "go east - Takes you into the scene to the east, if it exists.";
	}
}