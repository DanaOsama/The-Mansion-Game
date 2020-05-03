import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Game {
    //Attributes
    // private ArrayList<GoldenKey> keys = new ArrayList<GoldenKey>();
    public static void main(String[] args)
    {
        Output out = new Output();
        Scanner input = new Scanner(System.in);
        String userInput;
        Scene currentScene;
        Ticker tick = new Ticker(out);
        SupplyRoomScene supplyRoom = SupplyRoomScene.getInstance("Supply Room", out, tick);
        
        //The first scene is the supplyRoom
        currentScene = supplyRoom;

        //Welcome message to the game
        out.println("You wake up in a cold daze. You don't remember where you are, and you feel really sluggish. Slowly, you rise up to your feet.");
        while(true)
        {
            out.print("> ");
            userInput = input.nextLine().toLowerCase();
            StringTokenizer parsedInput = new StringTokenizer(userInput);

            //Here is how the parser should work
            //Input: read old note
            //Command: read
            //Arguments: old note

            //Check that the user typed anything at all
            if (parsedInput.hasMoreTokens())
            {
                String command = parsedInput.nextToken();
                String argument = "";
                while (parsedInput.hasMoreTokens())
                {
                    argument = argument + parsedInput.nextToken() + " ";
                }
                argument = argument.trim();
                // out.println("Command: " + command);
                // out.println("Argument: " + argument);

                //Temporary switch statement to do commands :)
                switch(command)
                {
                    case "read":
                        if (argument.length() > 0)
                        {
                            if (currentScene.findObject(argument))
                            {
                                try {
                                    Object temp = currentScene.getObject(argument);
                                    temp.read();
                                } catch(Exception e) {System.out.println(e);}
                            }
                            else
                            {
                                out.println("I couldn't find " + argument + " in the room.");
                            }
                        }
                        else
                        {
                            out.println("Read what?");
                        }
                        break;
                    case "get":
                        break;
                    case "look":
                        if (argument.equals("around"))
                        {
                            currentScene.printDescription();
                        }
                        break;
                    case "exit":
                        out.print("Are you sure you want to leave? [Y/N]: ");
                        String answer = input.nextLine().trim().toLowerCase();
                        if (answer.equals("y"))
                        {
                            //Exit message
                            out.println("Thank you for playing our game. Exiting...");
                            input.close();
                            System.exit(0);
                        }
                    default:
                        out.println("I don't know how to do that.");
                }
            }

            //TODO: Tick only on correct syntax commands
            tick.tick();
        }
    }
}
