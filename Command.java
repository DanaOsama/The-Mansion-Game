public interface Command {
	String execute();
	void setObject(Object o);
	void setPlayer(Player p);
	String getHelp();
}