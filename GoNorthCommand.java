public class GoNorthCommand implements Command {
	private Player player;

	public void setPlayer(Player p)
	{
		this.player = p;
	}

	public void setObject(Object o){};
	public void setCharacter(Character c){};

	public String execute()
	{
		this.player.getCurrentScene().goNorth(this.player);
		return "You head north.";
	}

	public String getHelp()
	{
		return "go north - Takes you into the scene to the north, if it exists.";
	}
}