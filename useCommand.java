public class useCommand implements Command {
	private Object obj;

	public useCommand(Object o)
	{
		this.obj = o;
    }
    
    public void execute()
    {
        this.obj.use();
    }
}