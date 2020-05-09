public class TalkToCommand implements Command {
	private Character character;

	public void setPlayer(Player p){};
	public void setObject(Object o){};
	public void setCharacter(Character c)
	{
		this.character = c;
	}

	public String execute()
	{
		return this.character.talkTo();
	}

	public String getHelp()
	{
		return "talkto <character> - Lets you interact with a character in the current scene.";
	}
}