public class SceneControlPanel {
	private Command[] slots;
	private Player player;

	public SceneControlPanel(Command[] c)
    {
		this.slots = c;
	}

	public void setPlayer(Player p)
	{
		this.player = p;
	}

	public String executeCommand(int index)
	{
		try {
			this.slots[index].setPlayer(this.player);
			return this.slots[index].execute();
		} catch (IndexOutOfBoundsException e) {return e.toString();}
	}
}