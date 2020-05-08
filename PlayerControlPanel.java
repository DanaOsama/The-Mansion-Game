public class PlayerControlPanel {
	private Command[] slots;
	private Object receiver;
	private Player player; //Needed to interact with player's inventory
	public PlayerControlPanel(Command[] c)
    {
		this.slots = c;
	}

	public void setObject(Object o)
	{
		this.receiver = o;
	}

	public void setPlayer(Player p)
	{
		this.player = p;
	}

	public String executeCommand(int index)
	{
		try {
			this.slots[index].setObject(this.receiver);
			this.slots[index].setPlayer(this.player);
			return this.slots[index].execute();
		} catch (IndexOutOfBoundsException e) {return e.toString();}
	}
}