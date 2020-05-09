public class Game {
    public Game()
    {
		//Before we start, print an intro
		ConsoleColors cc = new ConsoleColors();
		System.out.println(cc.WHITE_BACKGROUND + cc.BLACK_BOLD + "The Old House" + cc.RESET);

        Ticker tick = new Ticker();
		UserInterface ui = new UserInterface(tick);
		//Create scenes
		SupplyRoomScene supplyRoom = SupplyRoomScene.getInstance("Supply Room", ui, tick);
		MainEntranceScene mainScene = MainEntranceScene.getInstance("Main Entrance", ui, tick);
		BackyardScene backyardScene = BackyardScene.getInstance("Backyard", ui, tick);
		DiningRoomScene diningRoom = DiningRoomScene.getInstance("Dining Room", ui, tick);
		OutsideScene outsideScene = OutsideScene.getInstance("The outside", ui, tick);
		supplyRoom.setEast(mainScene);
		mainScene.setWest(supplyRoom);
		mainScene.setNorth(backyardScene);
		mainScene.setEast(diningRoom);
		mainScene.setSouth(outsideScene);
		backyardScene.setSouth(mainScene);
		diningRoom.setWest(mainScene);

		Scene[] allScenes = {supplyRoom, mainScene, backyardScene, diningRoom};

		//Player
		Player p = Player.getInstance("player", supplyRoom, ui);

		//Ghost
		Ghost g = new Ghost(allScenes, tick, p, ui);

		//Create the characters
		Butler butler = Butler.getInstance(mainScene, "Near the door leading outside, there stands a butler with an ominous atmosphere.", p);
		Suhaib suhaib = Suhaib.getInstance(diningRoom, "In the proximity of the dining table, there sits Suhaib the Computer Engineer.", p);
    }
}
