import java.util.Random;
public class ScareGhostBehavior extends GhostBehavior
{
    String[] scaryThings = {"I will make you regret the day you entered Master's house.", "You would look good... covered in blood.." , "I would watch out if I were you." , "You are living your last moments."};
    public void behave(Player p, Ghost g){
        int index = new Random().nextInt(scaryThings.length);
        g.notifyObservers("You have encountered a ghost! They look at you and say: " + cc.RED_BOLD + this.scaryThings[index] + cc.RESET);
        p.hurt("You were attacked by an angry ghost! You lost a heart.");
    }
}