import java.util.ArrayList;
import java.util.Random;
public class Ghost implements Observer, UISubject, Runnable {

    //Ghosts appear only during the night cycle of the game
    Scene[] scenes;
    GhostBehavior[] behaviors = {new ScareGhostBehavior(), new HealingGhostBehavior(), new TeleportingGhostBehavior(), new IndifferentGhostBehavior()};
    Scene currentScene = null;
    GhostBehavior gh = null;
    Ticker time;
    Player player;
    Thread currentThread;
    int sceneState = 0;
    ArrayList<UIObserver> uiObservers = new ArrayList<UIObserver>();
    ConsoleColors cc = new ConsoleColors();
    public Ghost(Scene[] s, Ticker t, Player p, UserInterface ui)
    {
        this.time = t;
        this.time.registerObserver(this);
        this.uiObservers.add(ui);
        this.scenes = s;
        this.player = p;
        this.currentThread = new Thread(this);
        this.currentThread.start();
    }

    //Observer method
    public void update()
    {
        this.sceneState = this.time.getState();
    }

    // UISubject Methods
    @Override
    public void registerObserver(UIObserver o) {
        uiObservers.add(o);

    }

    @Override
    public void removeObserver(UIObserver o) {
        int i = uiObservers.indexOf(o);
        if (i >= 0) uiObservers.remove(i);
    }

    @Override
    public void notifyObservers(String s) {
        for (int i = 0; i < uiObservers.size(); i++) {
            UIObserver temp = (UIObserver) uiObservers.get(i);
            temp.update(s);
        }
    }

    //A getter for the SupplyRoom scene
    public Scene getSupplyRoom()
    {
        //We know it is the first one
        return this.scenes[0];
    }

    public void run()
    {
        while (true)
        {
            try {
                //If it is night
                if (this.sceneState == 1)
                {
                    if (this.gh == null)
                    {
                        int choice = new Random().nextInt(this.behaviors.length);
                        this.currentScene = this.scenes[new Random().nextInt(this.scenes.length)];
                        notifyObservers(cc.CYAN_BOLD + "A ghost has appeared in " + this.currentScene.getName() + "!" + cc.RESET);
                        this.gh = this.behaviors[choice];
                    }
                    else
                    {
                        if (this.player.getCurrentScene().getName().equals(this.currentScene.getName()))
                        {
                            //The player has entered a scene we are in. Time to do behavior
                            gh.behave(this.player, this);
                            Thread.sleep(60000);
                            this.gh = null;
                        }
                    }
                }
                else
                {
                    //If we are in a scene, let's remove ourselves and announce our disappearance
                    if (this.currentScene != null)
                    {
                        this.currentScene = null;
                        this.gh = null;
                        notifyObservers(cc.CYAN_BOLD + "As the sun rises over the house, the ghost disappears with one final scream." + cc.RESET);
                    }
                }
                Thread.sleep(5000); //Sleep for 5 seconds
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}