public class GoWestCommand implements Command {
	private Player player;

	public void setPlayer(Player p)
	{
		this.player = p;
	}

	public void setObject(Object o){};

	public String execute()
	{
		this.player.getCurrentScene().goWest(this.player);
		return "You head west.";
	}

	public String getHelp()
	{
		return "go west - Takes you into the scene to the west, if it exists.";
	}
}