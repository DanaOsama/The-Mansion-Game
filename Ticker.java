import java.util.ArrayList;
public class Ticker implements Runnable, Subject {
    Thread currentThread;
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private int state = 0; //0 for day, 1 for night
    private int totalTicks = 0;
    private int stateTicks = 0;
    private Output out;

    public Ticker(Output o)
    {
        this.out = o;
        currentThread = new Thread(this);
        currentThread.start();
    }

    //Getters
    synchronized public int getState()
    {
        return this.state;
    }

    synchronized public int totalTicks()
    {
        return this.totalTicks;
    }

    synchronized public int stateTicks()
    {
        return this.stateTicks;
    }

    public void registerObserver(Observer o)
    {
        observers.add(o);
    }
    
    public void removeObserver(Observer o)
    {
        int i = observers.indexOf(o);
        if (i >= 0) observers.remove(i);
    }
    
    public void notifyObservers()
    {
        for( int i = 0; i < observers.size(); i++)
        {
            Observer observer = (Observer) observers.get(i);
            observer.update();
        }
    }
    
    synchronized public void tick()
    {
        this.totalTicks++;
        this.stateTicks++;
        
        if (this.stateTicks == 20)
        {
            //Flip the state
            this.state = 1 - this.state;
            this.stateTicks = 0;

            //Let's announce to the game
            if (this.state == 0)
            {
                out.println("Suddenly, you hear the sounds of a grandfather clock. It is now morning.");
            }
            else
            {
                out.println("Suddenly, you hear the sounds of a grandfather clock. It is now night.");
            }
        }
        
        this.notifyObservers();
    }
    
    public void run()
    {
        while (true)
        {
            //do nothing
        }
    }
}