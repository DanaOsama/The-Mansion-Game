import java.util.ArrayList;
public class Ticker implements Runnable, UISubject, Subject {
    Thread currentThread;
    private ArrayList<UIObserver> uiObservers = new ArrayList<UIObserver>();
    private ArrayList<Observer> timeObservers = new ArrayList<Observer>();
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

    public void registerObserver(Observer o)
    {
        timeObservers.add(o);
    }

    public void removeObserver(Observer o)
    {
        int i = timeObservers.indexOf(o);
        if (i >= 0) timeObservers.remove(i);
    }

    public void notifyObservers()
    {
        for( int i = 0; i < timeObservers.size(); i++)
        {
            Observer observer = timeObservers.get(i);
            observer.update();
        }
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
        for( int i = 0; i < uiObservers.size(); i++)
        {
            UIObserver observer = (UIObserver) uiObservers.get(i);
            observer.update(s);
        }
    }

    public void skipState()
    {
        //This is to have consequences for resting, like objects rotting
        int ticksNeeded = 300 - this.stateTicks;
        for (int i = 0; i < ticksNeeded; i++)
        {
            this.tick();
        }
    }

    synchronized public void tick()
    {
        this.totalTicks++;
        this.stateTicks++;
        if (this.stateTicks == (5 * 60))
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
        this.notifyObservers(); //Notify time observers
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