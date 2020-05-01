public class NoteObject extends Object {
	protected String content;
	NoteObject(Scene s, String n, String c)
	{
		super(s, n);
    }
	
	//Override the read function
	@Override
	public void read()
	{
        System.out.println("You open the note with tired hands. It reads: ");
		System.out.println(this.content);
	}
}