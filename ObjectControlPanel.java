public class ObjectControlPanel {
    private Command[] slots;
	private Object receiver;
	public ObjectControlPanel(Command[] c)
    {
		this.slots = c;
	}

	public void setObject(Object o)
	{
		this.receiver = o;
	}

	public String executeCommand(int index)
	{
		try {
			this.slots[index].setObject(this.receiver);
			return this.slots[index].execute();
		} catch (IndexOutOfBoundsException e) {return e.toString();}
	}
}