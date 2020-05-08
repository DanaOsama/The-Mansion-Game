import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface implements UISubject, UIObserver, Runnable {
    Thread currentThread;
    ArrayList<UIObserver> observers = new ArrayList<UIObserver>();
    Scanner input = new Scanner(System.in);
    Ticker tick;

    public UserInterface(Ticker t) {
        this.tick = t;
        this.tick.registerObserver(this);
        currentThread = new Thread(this);
        currentThread.start();
    }

    public void run() {
        while (true) {
            System.out.print("\r> ");
            String playerInput = this.input.nextLine().toLowerCase();
            this.notifyObservers(playerInput);
        }
    }

    // Observer Method
    @Override
    synchronized public void update(String s) {
        // Once we get a string to print, we will print them reprint the prompt
        System.out.println("\r" + s);
        System.out.print("> ");
    }

    // Subject Methods
    @Override
    public void registerObserver(UIObserver o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(UIObserver o) {
        int i = this.observers.indexOf(o);
        if (i >= 0) this.observers.remove(i);
    }

    @Override
    public void notifyObservers(String s) {
        for (int i = 0; i < this.observers.size(); i++)
        {
            UIObserver temp = this.observers.get(i);
            temp.update(s);
        }
    }
}