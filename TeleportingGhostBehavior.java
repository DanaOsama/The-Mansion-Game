import java.util.Random;
public class TeleportingGhostBehavior extends GhostBehavior {
	String[] teleThings = {"Let's take you back to the start!", "Now you're here, now you're there!", "Hey, want to see this cool trick I learned?", "Wouldn't it suck if I teleported you?", "With the snap of my fingers, you're back at the start!"};
    public void behave(Player p, Ghost g){
        int index = new Random().nextInt(teleThings.length);
		g.notifyObservers("You have encountered a ghost! They look at you and say: " + cc.BLUE_BOLD + this.teleThings[index] + cc.RESET);
		p.changeScene(g.getSupplyRoom());
		g.notifyObservers(cc.YELLOW + "Light envelops you and you suddenly find yourself in the Supply Room." + cc.RESET);
    }
}