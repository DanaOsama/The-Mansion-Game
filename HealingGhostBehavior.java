import java.util.Random;
public class HealingGhostBehavior extends GhostBehavior{

    String[] healThings = {"You are looking a little pale. Here is an apple to cheer you up.", "You need some color back in those cheeks. Here is a small surprise.","You're looking like a ghost. Take this apple.", "An apple a day keeps the ghosts away.."};

    public void behave(Player p, Ghost g){
        int index = new Random().nextInt(healThings.length);
        g.notifyObservers("You have encountered a ghost! They look at you and say: " + this.healThings[index]);
		//TODO: FINISH THE APPLE CLASS AND GENERATE ONES HERE!
	}
}