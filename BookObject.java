public class BookObject extends Object {
    public BookObject(Scene s, String n, String d)
    {
        super(s, n, d);
	}

	@Override
	public String read()
	{
		//Now we have to add a key to the scene, thankfully we have a reference to current scene
		try {
			Object temp = this.currentScene.getObject("book");

			//Remove the book
			this.currentScene.takeObject(temp);

			//Add the key
			SupplyRoomKey key = new SupplyRoomKey(this.currentScene, "key", "A black key lies on the scattered pages of the book." );
			this.currentScene.addObject(key);

			return ("As you take the book from the shelf, its pages scatter into the air and something hard clangs loudly as it hit the floor.");
		} catch (Exception e) {return e.toString();}
	}

	@Override
	public String take(Player p)
	{

		//Now we have to add a key to the scene, thankfully we have a reference to current scene
		try {
			Object temp = this.currentScene.getObject("book");

			//Remove the book
			this.currentScene.takeObject(temp);

			//Add the key
			SupplyRoomKey key = new SupplyRoomKey(this.currentScene, "key", "A black key lies on the scattered pages of the book." );
			this.currentScene.addObject(key);

			return("As you take the book from the shelf, its pages scatter into the air and something hard clangs loudly as it hit the floor.");
		} catch (Exception e) {e.printStackTrace(); return e.toString();}
	}
}