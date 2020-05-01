public class ReadCommand implements Command {
	private Object obj;

	public ReadCommand(Object o)
	{
		this.obj = o;
	}

	public void execute()
	{
		this.obj.read();
	}
}