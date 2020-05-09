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
	protected ConsoleColors cc = new ConsoleColors();
	protected ArrayList<Character> characters = new ArrayList<Character>();

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
		this.describeCharacters();
		this.describeSurroundings();
	}

	abstract protected void describeSelf();

	protected void describeObjects() {
		// If there are no objects in the scene
		if (objects.size() == 0) {
			this.notifyObservers(cc.YELLOW + "Nothing useful here." + cc.RESET);
		} else {
			for (int i = 0; i < objects.size(); i++) {
				this.notifyObservers(cc.BLUE + objects.get(i).getSceneDescription() + cc.RESET);
			}
		}
	}

	protected void describeSurroundings() {
		if (north != null) {
			this.notifyObservers(cc.YELLOW + north.getName() + " is in the north." + cc.RESET);
		}

		if (east != null) {
			this.notifyObservers(cc.YELLOW + east.getName() + " is in the east." + cc.RESET);
		}

		if (south != null) {
			this.notifyObservers(cc.YELLOW + south.getName() + " is in the south." + cc.RESET);
		}

		if (west != null) {
			this.notifyObservers(cc.YELLOW + west.getName() + " is in the west." + cc.RESET);
		}
	}

	protected void describeCharacters()
	{
		if (this.characters.size() > 0)
		{
			for (int i = 0; i < this.characters.size(); i++)
			{
				this.notifyObservers(this.characters.get(i).getSceneDescription());
			}
		}
		else
		{
			this.notifyObservers(cc.CYAN + "There is no one here other than you." + cc.RESET);
		}
	}

	// Object related functions
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

	void addObject(Object obj) {
		obj.setScene(this);
		objects.add(obj);
	}

	//Functions related to characters
	public boolean findCharacter(String s)
	{
		for (int i = 0; i < this.characters.size(); i++)
		{
			if (this.characters.get(i).getName().equals(s))
			{
				return true;
			}
		}
		return false;
	}

	public Character getCharacter(String s) throws Exception
	{
		for (int i = 0; i < characters.size(); i++) {
			if (s.equals(characters.get(i).getName())) {
				return characters.get(i);
			}
		}

		// If the object is not found in the scene, throw an exception
		throw new Exception(s + " was not found in scene " + this.name);
	}

	public void removeCharacter(Character c) throws Exception
	{
		int i = this.characters.indexOf(c);
		if (i >= 0)
		{
			this.characters.remove(c);
		}
		else
		{
			throw new Exception(c.getName() + " was not found in scene " + this.name);
		}
	}

	public void addCharacter(Character c)
	{
		this.characters.add(c);
	}

	//Getters
	String getName() {
		return this.name;
	}

	Ticker getTicker()
	{
		return this.tick;
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