public class LookAroundCommand implements Command {
	private Player player;

	public void setPlayer(Player p)
	{
		this.player = p;
	}

	public void setObject(Object o){};

	public String execute()
	{
		this.player.getCurrentScene().printDescription();
		return "";
	}

	public String getHelp()
	{
		return "look around - This will describe your surroundings and the room you are in.";
	}
}