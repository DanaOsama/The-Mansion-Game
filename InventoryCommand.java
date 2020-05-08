public class InventoryCommand implements Command {
	private Player player;

	public void setPlayer(Player p)
	{
		this.player = p;
	}

	public void setObject(Object o){};

	public String execute()
	{
		return this.player.listInventory();
	}

	public String getHelp()
	{
		return "inv - This will show you your inventory.";
	}
}