import java.util.Random;
public class IndifferentGhostBehavior extends GhostBehavior{
    String[] mehThings = {"Floating into walls hurts a little.", "The Butler is Master's oldest friend." , "Is there more to life than being a ghost trapped in an 20s house?" , "Oh, you're here again."};

    public void behave(Player p, Ghost g){
        int index = new Random().nextInt(mehThings.length);
        g.notifyObservers("You have encountered a ghost! They look at you and say: " + cc.YELLOW_BOLD + this.mehThings[index] + cc.RESET);
    }
}