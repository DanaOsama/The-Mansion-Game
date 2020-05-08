public class ReadCommand implements Command {
	private Object obj;

	public void setObject(Object o)
	{
		this.obj = o;
	}

	public String execute()
	{
		return this.obj.read();
	}

	public void setPlayer(Player p){};

	public String getHelp()
	{
		return "read <object> - This will let you read items in the room you are in.";
	}
}