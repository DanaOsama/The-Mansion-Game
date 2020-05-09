import java.util.ArrayList;
abstract public class Character implements Runnable, UISubject {
	protected Scene currentScene;
	protected String name;
	protected String sceneDescription;
	protected ArrayList<UIObserver> uiObservers = new ArrayList<UIObserver>();
	protected ConsoleColors cc = new ConsoleColors();
	protected Thread currentThread;
	protected Player player;
	public Character(Scene currentScene, String name, String s, Player p)
	{
		this.currentScene = currentScene;
		this.currentScene.addCharacter(this);
		this.registerObserver(this.currentScene.ui);
		this.name = name;
		this.sceneDescription = s;
		this.player = p;
		this.currentThread = new Thread(this);
		this.currentThread.start();
	}

	public String getName()
	{
		return this.name;
	}

	public String getSceneDescription()
	{
		return this.sceneDescription;
	}

    public void registerObserver(UIObserver o)
    {
        uiObservers.add(o);
    }

    public void removeObserver(UIObserver o)
    {
        int i = uiObservers.indexOf(o);
        if (i >= 0) uiObservers.remove(i);
	}

	public void notifyObservers(String s)
	{
		for (int i = 0; i < uiObservers.size(); i++)
		{
			uiObservers.get(i).update(s);
		}
	}

	public abstract void run();
	public abstract String talkTo();
}