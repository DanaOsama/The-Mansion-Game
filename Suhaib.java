import java.util.Random;

public class Suhaib extends Character {

	public Suhaib(Scene currentScene, String name, String s) {
		super(currentScene, name, s);
		m = new Mood(this);
		m.PlayerInRoom = true;
	}

	public void SetScene(Scene scene)
	{
		currentScene = scene;
	}

	//TODO: Give player final golden key
	public void DrinkWater(BucketObject o)
	{
		notifyObservers("This "+ o + "of water is very tasty!");
		notifyObservers("Here is a key I found in the dining room.");
		// return new DiningRoomKey();
	}

	public void run()
	{
		Random rand = new Random();
		m.printStatus();
		m.nextState();
		while(m.PlayerInRoom && !m.Free)
		{
			m.printStatus();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		m.nextState();
		m.printStatus();
		while(m.PlayerInRoom && m.Free)
		{
			m.nextState();
			for(int i = 0; i<(rand.nextInt(3))+1; i++)
			{
				m.printStatus();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
