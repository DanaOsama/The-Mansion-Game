public class BookObject extends Object {
    public BookObject(Scene s, String n, Output o, String d)
    {
        super(s, n, o, d);
	}
	
	@Override
	public void read()
	{
        out.println("As you take the book from the shelf, its pages scatter into the air and " + 
        "something hard clangs loudly as it hit the floor.");

		//Now we have to add a key to the scene, thankfully we have a reference to current scene
		try {
			Object temp = this.currentScene.getObject("book");

			//Remove the book
			this.currentScene.takeObject(temp);

			//Add the key
			SupplyRoomKey key = new SupplyRoomKey(this.currentScene, "key", this.out, "A black key lies on the scattered pages of the book." );
			this.currentScene.addObject(key);
			
		} catch (Exception e) {System.out.println(e);}
	}

	@Override
	public void take(Player p)
	{
		out.println("As you take the book from the shelf, its pages scatter into the air and " + 
        "something hard clangs loudly as it hit the floor.");

		//Now we have to add a key to the scene, thankfully we have a reference to current scene
		try {
			Object temp = this.currentScene.getObject("book");

			//Remove the book
			this.currentScene.takeObject(temp);

			//Add the key
			SupplyRoomKey key = new SupplyRoomKey(this.currentScene, "key", this.out, "A black key lies on the scattered pages of the book." );
			this.currentScene.addObject(key);
			
		} catch (Exception e) {System.out.println(e);}
	}
}