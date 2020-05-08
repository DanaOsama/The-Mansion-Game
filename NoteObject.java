public class NoteObject extends Object {
	protected String content;
	public NoteObject(Scene s, String n, String c, String d)
	{
		super(s, n, d);
		this.content = c;
    }

	//Override the read function
	@Override
	public String read()
	{
        return ("You open the note with tired hands. It reads: " + this.content);
	}

	@Override
	public String take(Player p)
	{
		p.takeItem(this, "An old note. It contains: " + this.content);
		return (this.getName() + " has been added to your inventory.");
	}

	@Override
	public String inspect()
	{
		return (this.getSceneDescription() + ". It reads: " + this.content);
	}
}