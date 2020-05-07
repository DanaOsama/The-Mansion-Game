import java.util.ArrayList;
import java.util.Scanner;
public class UserInterface implements UISubject, UIObserver, Runnable {
    Thread currentThread;
    ArrayList<Observer> observers = new ArrayList<Observer>();
	Scanner input = new Scanner(System.in);Ticker tick; 
    public UserInterface(Ticker t)
    {
        this.tick = t;
        this.tick.registerObserver(this);
        currentThread = new Thread(this);
        currentThread.start();
	}
	
    public void run()
    {
		while (true)
		{
            System.out.print("> ");
			String playerInput = this.input.nextLine();
			System.out.println(playerInput);
		}
    }

    //Observer Method
    @Override
    public void update(String s) {
		//Once we get a string to print, we will print them reprint the prompt
		System.out.println("\r" + s);
		System.out.print("> ");
    }

    //Subject Methods
    @Override
    public void registerObserver(UIObserver o) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeObserver(UIObserver o) {
        // TODO Auto-generated method stub

    }

    @Override
    public void notifyObservers(String s) {
        // TODO Auto-generated method stub

    }
}