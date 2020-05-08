import java.util.ArrayList;

abstract public class Scene implements UISubject {

	protected String name;
	protected Thread currentThread;
	protected ArrayList<Object> objects = new ArrayList<Object>();
	protected ArrayList<UIObserver> uiObservers = new ArrayList<UIObserver>();
	protected int currentState = 0;
	protected UserInterface ui;
	private Ticker tick;
	protected SceneBehavior behavior;

	// Constructor
	public Scene(String n, UserInterface UI, Ticker t) {
		this.name = n;
		this.ui = UI;
		this.tick = t;
		this.uiObservers.add(this.ui);
	}

	// Scenes
	protected Scene north = null;
	protected Scene east = null;
	protected Scene south = null;
	protected Scene west = null;

	// Movement functions
	public void setNorth(Scene s) {
		this.north = s;
	}

	public void setEast(Scene s) {
		this.east = s;
	}

	public void setSouth(Scene s) {
		this.south = s;
	}

	public void setWest(Scene s) {
		this.west = s;
	}

	public void goNorth(Player p) {
		this.notifyObservers("Cannot go north, there is nothing there.");
	}

	public void goEast(Player p) {
		this.notifyObservers("Cannot go there, there is nothing there.");
	}

	public void goSouth(Player p) {
		this.notifyObservers("Cannot go south, there is nothing there.");
	}

	public void goWest(Player p) {
		this.notifyObservers("Cannot go west, there is nothing there.");
	}

	public String changeScene(Scene s, Player p)
	{
		//Call the player's change scene
		p.changeScene(s);
		return s.getMoveDescription();
	}

	public void sceneBehavior(){}; //By default does nothing, as some scenes dont do behavior
	public void setBehavior(SceneBehavior b){}; //By default does nothing, not all scenes need it

	// Description functions
	abstract protected String getMoveDescription();

	void printDescription() {
		this.describeSelf();
		this.describeObjects();
		this.describeSurroundings();
	}

	abstract protected void describeSelf();

	protected void describeObjects() {
		// If there are no objects in the scene
		if (objects.size() == 0) {
			this.notifyObservers("Nothing useful here.");
		} else {
			for (int i = 0; i < objects.size(); i++) {
				this.notifyObservers(objects.get(i).getSceneDescription());
			}
		}
	}

	protected void describeSurroundings() {
		if (north != null) {
			this.notifyObservers(north.getName() + " is in the north.");
		}

		if (east != null) {
			this.notifyObservers(east.getName() + " is in the east.");
		}

		if (south != null) {
			this.notifyObservers(south.getName() + " is in the south.");
		}

		if (west != null) {
			this.notifyObservers(west.getName() + " is in the west.");
		}
	}

	// Run this only once with initial list of objects
	abstract protected void loadObjects();

	boolean findObject(String n) {
		for (int i = 0; i < objects.size(); i++) {
			if (n.equals(objects.get(i).getName())) {
				return true;
			}
		}
		return false;
	}

	Object getObject(String n) throws Exception {
		for (int i = 0; i < objects.size(); i++) {
			if (n.equals(objects.get(i).getName())) {
				return objects.get(i);
			}
		}

		// If the object is not found in the scene, throw an exception
		throw new Exception(n + " was not found in scene " + this.name);
	}

	void takeObject(Object o) throws Exception {
		int i = objects.indexOf(o);
		if (i >= 0) {
			objects.remove(i);
		} else {
			// If the object is not found in the scene, throw an exception
			throw new Exception(o.getName() + " was not found in scene " + this.name);
		}
	}

	String getName() {
		return this.name;
	}

	Ticker getTicker()
	{
		return this.tick;
	}

	void addObject(Object obj) {
		objects.add(obj);
	}

	// UISubject Methods
	@Override
	public void registerObserver(UIObserver o) {
		uiObservers.add(o);

	}

	@Override
	public void removeObserver(UIObserver o) {
		int i = uiObservers.indexOf(o);
		if (i >= 0)
			uiObservers.remove(i);

	}

	@Override
	public void notifyObservers(String s) {
		for (int i = 0; i < uiObservers.size(); i++) {
			UIObserver temp = (UIObserver) uiObservers.get(i);
			temp.update(s);
		}
	}
}