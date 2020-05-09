public class StatusCommand implements Command {
	private Player player;

	public void setPlayer(Player p)
	{
		this.player = p;
	}

	public void setObject(Object o){};
	public void setCharacter(Character c){};

	public String execute()
	{
		return this.player.getStatus();
	}

	public String getHelp()
	{
		return "status - This will show you basic information about you.";
	}
}