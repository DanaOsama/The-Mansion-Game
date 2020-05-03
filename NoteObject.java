public class NoteObject extends Object {
	protected String content;
	public NoteObject(Scene s, String n, String c, Output o, String d)
	{
		super(s, n, o, d);
		this.content = c;
    }
	
	//Override the read function
	@Override
	public void read()
	{
        out.println("You open the note with tired hands. It reads: " + this.content);
	}
}