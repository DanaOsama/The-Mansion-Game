import java.util.Random;

public class Suhaib extends Character{
	
	public Suhaib(Scene currentScene, String name) {
		super(currentScene, name);
		m = new Mood(this);
		m.PlayerInRoom = true;
	}
	
	public void SetScene(Scene scene)
	{
		currentScene = scene;
	}
	
	public DiningRoomKey DrinkWater(BucketObject o)
	{
		System.out.println("This "+ o + "of water is very tasty!");
		System.out.println("Here is a key I found in the dining room.");
		return new DiningRoomKey();
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
			for(int i =0; i<(rand.nextInt(3))+1; i++)
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
