public class TakeCommand implements Command {
	private Object obj;
	private Player player;

	public void setObject(Object o)
	{
		this.obj = o;
	}

	public void setPlayer(Player p)
	{
		this.player = p;
	}

	public void setCharacter(Character c){};

	public String execute()
	{
		return this.obj.take(this.player);
	}

	public String getHelp()
	{
		return "take <object> - This will let you take items from rooms and place them into your inventory.";
	}
}