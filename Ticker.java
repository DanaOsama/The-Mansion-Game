import java.util.ArrayList;
public class Ticker implements Runnable, UISubject {
    Thread currentThread;
    private ArrayList<UIObserver> observers = new ArrayList<UIObserver>();
    private int state = 0; //0 for day, 1 for night
    private int totalTicks = 0;
    private int stateTicks = 0;

    public Ticker()
    {
        //this.out = o;
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

    public void registerObserver(UIObserver o)
    {
        observers.add(o);
    }
    
    public void removeObserver(UIObserver o)
    {
        int i = observers.indexOf(o);
        if (i >= 0) observers.remove(i);
    }
    
    public void notifyObservers(String s)
    {
        for( int i = 0; i < observers.size(); i++)
        {
            UIObserver observer = (UIObserver) observers.get(i);
            observer.update(s);
        }
    }
    
    synchronized public void tick()
    {
        this.totalTicks++;
        this.stateTicks++;
        
        if (this.stateTicks == (10))
        {
            //Flip the state
            this.state = 1 - this.state;
            this.stateTicks = 0;

            //Let's announce to the game
            if (this.state == 0)
            {
                notifyObservers("Suddenly, you hear the sounds of a grandfather clock. It is now morning.");
            }
            else
            {
                notifyObservers("Suddenly, you hear the sounds of a grandfather clock. It is now night.");
            }
        }
        // this.notifyObservers();
    }
    
    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep(1000);
                this.tick();
            } catch(Exception e) { e.printStackTrace(); }
        }
    }
}