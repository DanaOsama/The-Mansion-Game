public class EatCommand implements Command {
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
		return this.obj.eat(this.player);
	}

	public String getHelp()
	{
		return "eat <object> - This will let you eat items in your inventory";
	}
}