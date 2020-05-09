public class GoSouthCommand implements Command {
	private Player player;

	public void setPlayer(Player p)
	{
		this.player = p;
	}

	public void setObject(Object o){};
	public void setCharacter(Character c){};

	public String execute()
	{
		this.player.getCurrentScene().goSouth(this.player);
		return "You head south.";
	}

	public String getHelp()
	{
		return "go south - Takes you into the scene to the south, if it exists.";
	}
}