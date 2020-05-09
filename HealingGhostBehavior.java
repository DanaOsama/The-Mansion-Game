import java.util.Random;
public class HealingGhostBehavior extends GhostBehavior{

    String[] healThings = {"You are looking a little pale. Here is an apple to cheer you up.", "You need some color back in those cheeks. Here is a small surprise.","You're looking like a ghost. Take this apple.", "An apple a day keeps the ghosts away.."};
	ConsoleColors cc = new ConsoleColors();
    public void behave(Player p, Ghost g){
        int index = new Random().nextInt(healThings.length);
        g.notifyObservers("You have encountered a ghost! They look at you and say: " + cc.GREEN_BOLD + this.healThings[index] + cc.RESET);

        //Simple logic check, if there is already an apple in this scene, replace it
        if (p.getCurrentScene().findObject("apple"))
        {
            try {
                p.getCurrentScene().takeObject(p.getCurrentScene().getObject("apple"));
            } catch(Exception e) {e.printStackTrace();}
        }

        p.getCurrentScene().addObject(new AppleObject(p.getCurrentScene(), "apple", "A lovely red apple lies in a basket on the floor.", (new Random().nextInt(5) + 1) * 60));
        g.notifyObservers(cc.GREEN_BOLD + "An apple has appeared in this room!" + cc.RESET);
	}
}