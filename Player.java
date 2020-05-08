import java.util.ArrayList;
import java.util.StringTokenizer;

public class Player implements Runnable, UIObserver, UISubject {
    private static Player instance;
    private ArrayList<Object> inventory = new ArrayList<Object>();
    private ArrayList<UIObserver> uiObservers = new ArrayList<UIObserver>();
    private String name;
    private Scene currentScene;
    private UserInterface ui;
    private int lives = 3;
    private String currentPlayerInput = null;
    private Thread currentThread;

    // Control panels
    private Command[] objectCommands = { new ReadCommand() };
    private Command[] playerCommands = { new TakeCommand(), new InventoryCommand(), new InspectCommand(), new StatusCommand(), new EatCommand(), new UseCommand() };
    private Command[] sceneCommands = { new LookAroundCommand(), new GoNorthCommand(), new GoSouthCommand(), new GoEastCommand(),  new GoWestCommand()};
    private ObjectControlPanel ocp = new ObjectControlPanel(this.objectCommands);
    private PlayerControlPanel pcp = new PlayerControlPanel(this.playerCommands);
    private SceneControlPanel scp = new SceneControlPanel(this.sceneCommands);

    private Player(String n, Scene s, UserInterface u) {
        this.ui = u;
        this.ui.registerObserver(this);
        this.registerObserver(this.ui);
        this.name = n;
        this.currentScene = s;
        // this.currentThread = new Thread(this);
        // this.currentThread.start();
    }

    // Singleton design pattern
    synchronized public static Player getInstance(String n, Scene s, UserInterface u) {
        if (instance == null) {
            instance = new Player(n, s, u);
            return instance;
        } else {
            return instance;
        }
    }

    // Setters
    public void changeScene(Scene s) {
        // Update all the items in our inventory that we changed scenes
        for (int i = 0; i < this.inventory.size(); i++) {
            this.inventory.get(i).setScene(s);
        }

        // Finally, change our own scene
        this.currentScene = s;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public Scene getCurrentScene() {
        return this.currentScene;
    }

    public String getStatus() {
        return "You are in the " + this.currentScene.getName() + ". You currently have " + this.inventory.size()
                + " items in your inventory. You have " + this.lives + " hearts left.";
    }

    public void hurt(String s)
    {
        this.lives--;
        this.notifyObservers(s);
        this.notifyObservers("You have " + this.lives + " hearts left.");
        if (this.lives == 0)
        {
            notifyObservers("Your body drops dead on the ground. GAME OVER.");
            System.exit(0);
        }
    }

    public void run() {
        while (true) {
            if (this.currentPlayerInput != null) {
                System.out.println("Player input is not null :)");

                this.currentPlayerInput = null;
            }
        }
    }

    // Inventory functions
    public void takeItem(Object obj, String d) {
        try {
            // Take it from the scene
            obj.setSceneDescription(d);
            inventory.add(obj);

            // Remove it from the scene
            currentScene.takeObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String listInventory() {
        if (inventory.size() == 0) {
            return "There is nothing in your inventory.";
        } else {
            String res = "~ Inventory ~\n";
            for (int i = 0; i < inventory.size(); i++) {
                res += " - " + inventory.get(i).getName() + "\n";
            }
            return res;
        }
    }

    void addObject(Object obj, String d) {
        obj.setSceneDescription(d);
        inventory.add(obj);
    }

    void removeObject(Object o) {
        int i = inventory.indexOf(o);
        if (i >= 0)
            inventory.remove(i);
    }

    Object getObject(String n) throws Exception {
        for (int i = 0; i < inventory.size(); i++) {
            if (n.equals(inventory.get(i).getName())) {
                return inventory.get(i);
            }
        }

        // If the object is not found in the scene, throw an exception
        throw new Exception(n + " was not found in inventory " + this.name);
    }

    boolean findObject(String n) {
        for (int i = 0; i < inventory.size(); i++) {
            if (n.equals(inventory.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    // UISubject Methods
    @Override
    public void registerObserver(UIObserver o) {
        uiObservers.add(o);

    }

    @Override
    public void removeObserver(UIObserver o) {
        int i = uiObservers.indexOf(o);
        if (i >= 0)
            uiObservers.remove(i);

    }

    @Override
    public void notifyObservers(String s) {
        for (int i = 0; i < uiObservers.size(); i++) {
            UIObserver temp = (UIObserver) uiObservers.get(i);
            temp.update(s);
        }
    }
    
    void setUserInterface(UserInterface UI) {
        this.ui = UI;
        this.ui.registerObserver(this);
    }

    // UIObserver method
    // Received command from user
    public void update(String s) {
        StringTokenizer parsedInput = new StringTokenizer(s);
        if (parsedInput.hasMoreTokens()) {
            String command = parsedInput.nextToken();
            String argument = "";
            while (parsedInput.hasMoreTokens()) {
                argument = argument + parsedInput.nextToken() + " ";
            }
            argument = argument.trim();

            // Parse the command
            switch (command) {
                // Object commands
                case "read":
                    if (argument.length() > 0) {
                        if (currentScene.findObject(argument)) {
                            try {
                                Object temp = currentScene.getObject(argument);
                                this.ocp.setObject(temp);
                                this.notifyObservers(this.ocp.executeCommand(0));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            notifyObservers("I couldn't find " + argument + " in the room.");
                        }
                    } else {
                        notifyObservers("Read what?");
                    }
                    break;
                // Scene commands
                case "look":
                    if (argument.equals("around")) {
                        this.scp.setPlayer(this);
                        this.scp.executeCommand(0);
                    } else {
                        notifyObservers("Look where?");
                    }
                    break;
                case "go":
                    if (argument.length() > 0) {
                        if (argument.equals("north")) {
                            this.scp.setPlayer(this);
                            this.scp.executeCommand(1);
                        } else if (argument.equals("south")) {
                            this.scp.setPlayer(this);
                            this.scp.executeCommand(2);
                        } else if (argument.equals("east")) {
                            this.scp.setPlayer(this);
                            this.scp.executeCommand(3);
                        } else if (argument.equals("west")) {
                            this.scp.setPlayer(this);
                            this.scp.executeCommand(4);
                        } else {
                            notifyObservers("Invalid direction.");
                        }
                    } else {
                        notifyObservers("Go where?");
                    }
                    break;
                // Player commands
                case "take":
                    if (argument.length() > 0) {
                        if (currentScene.findObject(argument)) {
                            try {
                                Object temp = currentScene.getObject(argument);
                                this.pcp.setObject(temp);
                                this.pcp.setPlayer(this);
                                this.notifyObservers(this.pcp.executeCommand(0));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            notifyObservers("I couldn't find " + argument + " in the room.");
                        }
                    } else {
                        notifyObservers("Take what?");
                    }
                    break;
                case "inv":
                    this.pcp.setObject(null);
                    this.pcp.setPlayer(this);
                    this.notifyObservers(this.pcp.executeCommand(1));
                    break;
                case "inspect":
                    if (argument.length() > 0) {
                        if (this.findObject(argument)) {
                            try {
                                Object temp = this.getObject(argument);
                                this.pcp.setObject(temp);
                                this.pcp.setPlayer(null);
                                this.notifyObservers(this.pcp.executeCommand(2));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            notifyObservers("I could not find " + argument + " in my inventory.");
                        }
                    } else {
                        notifyObservers("Inspect what?");
                    }
                    break;
                case "status":
                    this.pcp.setObject(null);
                    this.pcp.setPlayer(this);
                    this.notifyObservers(this.pcp.executeCommand(3));
                    break;
                case "eat":
                    if (argument.length() > 0) {
                        if (this.findObject(argument)) {
                            try {
                                Object temp = this.getObject(argument);
                                this.pcp.setObject(temp);
                                this.notifyObservers(this.pcp.executeCommand(4));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            notifyObservers("I couldn't find " + argument + " in my inventory.");
                        }
                    } else {
                        notifyObservers("Eat what?");
                    }
                    break;
                case "use":
                    if (argument.length() > 0) {
                        if (this.findObject(argument)) {
                            try {
                                Object temp = this.getObject(argument);
                                this.pcp.setObject(temp);
                                this.notifyObservers(this.pcp.executeCommand(5));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            notifyObservers("I couldn't find " + argument + " in my inventory.");
                        }
                    } else {
                        notifyObservers("Use what?");
                    }
                    break;
                // Character commands
                case "talkto":
                    break;
                // System commands
                case "rest":
                    this.currentScene.getTicker().skipState();
                    break;
                case "?":
                case "help":
                    notifyObservers("Commands:");
                    for (int i = 0; i < objectCommands.length; i++) {
                        notifyObservers(" * " + objectCommands[i].getHelp());
                    }
                    for (int i = 0; i < playerCommands.length; i++) {
                        notifyObservers(" * " + playerCommands[i].getHelp());
                    }
                    for (int i = 0; i < sceneCommands.length; i++) {
                        notifyObservers(" * " + sceneCommands[i].getHelp());
                    }

                    // System commands
                    notifyObservers(" * rest - This will skip to the next day/night state.");
                    notifyObservers(" * help/? - I wonder what this command does...");
                    notifyObservers(" * exit - Well, exits the game.");
                    break;
                case "exit":
                    notifyObservers("Thank you for playing our game. Exiting...");
                    System.exit(0);
                default:
                    notifyObservers("Invalid command.");
            }
        }
    }
}