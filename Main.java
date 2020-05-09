public class Main {
    public static void main(String[] args) {
		//TODO: This is for debugging purposes, this will be moved to Game.java later
		Ticker tick = new Ticker();
		UserInterface ui = new UserInterface(tick);
		//Create scenes
		SupplyRoomScene supplyRoom = SupplyRoomScene.getInstance("Supply Room", ui, tick);
		MainEntranceScene mainScene = MainEntranceScene.getInstance("Main Entrance", ui, tick);
		supplyRoom.setEast(mainScene);
		mainScene.setWest(supplyRoom);
		Scene[] allScenes = {supplyRoom, mainScene};

		//Player
		Player p = Player.getInstance("player", supplyRoom, ui);

		//Ghost
		Ghost g = new Ghost(allScenes, tick, p, ui);

		//Create the characters
		Butler butler = Butler.getInstance(mainScene, "Near the door leading outside, there stands a butler with an ominous atmosphere.", p);
    }
}