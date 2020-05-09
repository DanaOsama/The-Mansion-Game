public class UseCommand implements Command {
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
		return this.obj.use(this.player);
	}

	public String getHelp()
	{
		return "use <object> - Lets you use items in your inventory.";
	}
}