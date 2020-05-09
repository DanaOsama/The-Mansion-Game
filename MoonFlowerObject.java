public class MoonFlowerObject extends Object implements Observer
{
    boolean bloom = false;
	int sceneState = -1;
	boolean inScene = true;
    public MoonFlowerObject(Scene s, String n, String d)
	{
        super(s, n, d);
        this.currentScene.getTicker().registerObserver(this);
    }

    @Override
	public String take(Player p)
	{
        if (bloom)
        {
			this.inScene = false;
			p.takeItem(this, "A sharp thorn taken from the Moon Flower plant. Maybe it can pick a lock?");
            return (this.getName() + " has been added to your inventory.");
        }
        else
        {
            return cc.RED + "The plant has not bloomed yet." + cc.RESET;
        }
    }

    @Override
	public String inspect()
	{
		return this.getSceneDescription();
    }

    @Override
    public String use(Player p)
    {
        if (this.getSceneName().equals("Main Entrance"))
        {
            try{
                Object temp = p.getObject(this.getName());
				p.removeObject(temp);
				this.currentScene.takeObject(this.currentScene.getObject("chest"));
				this.currentScene.addObject(new GoldenKey(this.currentScene, "golden key", "Now with the chest open, there lies a golden key inside it."));
                return this.cc.GREEN + "You unlocked the chest using the thorn from the moon flower." + this.cc.RESET;
                //Change state of main entrance to unlocked :)
            } catch(Exception e){return "Object not found!";}
        }
        else
        {
            return(this.cc.RED + "I don't see how " + this.getName() + " can be used in this room." + this.cc.RESET);
        }
	}

    //Observer method
    public void update()
    {
		if (this.inScene)
		{
			this.sceneState = this.currentScene.getTicker().getState();
			if (this.sceneState == 1)
			{
				this.setSceneDescription("On the dining table is a huge Moon Flower plant. It is eerily glowing lilac. It's petals are open.");
				this.bloom = true;
			}
			else
			{
				this.setSceneDescription("On the dining table is a huge Moon Flower plant. It is eerily glowing lilac. It's petals are closed.");
				this.bloom = false;
			}
		}
    }
}