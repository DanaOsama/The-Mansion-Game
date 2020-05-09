public class InspectCommand implements Command {
	private Object obj;

	public void setPlayer(Player p){};
	public void setCharacter(Character c){};

	public void setObject(Object o){
		this.obj = o;
	};

	public String execute()
	{
		return this.obj.getSceneDescription();
	}

	public String getHelp()
	{
		return "inspect <object> - This will let you inspect an item in your inventory to learn more about it.";
	}
}