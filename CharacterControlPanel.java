public class CharacterControlPanel {
	private Command[] slots;
	private Player player;
	private Object object;
	private Character character;

	public CharacterControlPanel(Command[] c)
    {
		this.slots = c;
	}

	public void setPlayer(Player p)
	{
		this.player = p;
	}

	public void setObject(Object o)
	{
		this.object = o;
	}

	public void setCharacter(Character c)
	{
		this.character = c;
	}

	public String executeCommand(int index)
	{
		try {
			this.slots[index].setPlayer(this.player);
			this.slots[index].setObject(this.object);
			this.slots[index].setCharacter(this.character);
			return this.slots[index].execute();
		} catch (IndexOutOfBoundsException e) {return e.toString();}
	}
}