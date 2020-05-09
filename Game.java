// import java.util.ArrayList;
// import java.util.Random;
// import java.util.Scanner;
// import java.util.StringTokenizer;
// public class Game {
//     //Attributes
//     // private ArrayList<GoldenKey> keys = new ArrayList<GoldenKey>();
//     public static void main(String[] args)
//     {
//         Scanner input = new Scanner(System.in);
//         String userInput;
//         Scene currentScene;
//         Ticker tick = new Ticker(out);
//         SupplyRoomScene supplyRoom = SupplyRoomScene.getInstance("Supply Room", out, tick);
        
//         //The first scene is the supplyRoom
//         currentScene = supplyRoom;
//         Player p = Player.getInstance("Youssef", out, currentScene);
        
//         //Welcome message to the game
//        this.notifyObservers("You wake up in a cold daze. You don't remember where you are, and you feel really sluggish. Slowly, you rise up to your feet.");
//         while(true)
//         {
//             out.print("> ");
//             userInput = input.nextLine().toLowerCase();
//             StringTokenizer parsedInput = new StringTokenizer(userInput);

//             //Here is how the parser should work
//             //Input: read old note
//             //Command: read
//             //Arguments: old note

//             //Check that the user typed anything at all
//             if (parsedInput.hasMoreTokens())
//             {
//                 String command = parsedInput.nextToken();
//                 String argument = "";
//                 while (parsedInput.hasMoreTokens())
//                 {
//                     argument = argument + parsedInput.nextToken() + " ";
//                 }
//                 argument = argument.trim();
//                 //this.notifyObservers("Command: " + command);
//                 //this.notifyObservers("Argument: " + argument);

//                 //Temporary switch statement to do commands :)
//                 switch(command)
//                 {
//                     case "read":
//                         if (argument.length() > 0)
//                         {
//                             if (currentScene.findObject(argument))
//                             {
//                                 try {
//                                     Object temp = currentScene.getObject(argument);
//                                     temp.read();
//                                 } catch(Exception e) {e.printStackTrace();}
//                             }
//                             else
//                             {
//                                this.notifyObservers("I couldn't find " + argument + " in the room.");
//                             }
//                         }
//                         else
//                         {
//                            this.notifyObservers("Read what?");
//                         }
//                         break;
//                     case "inspect":
//                         if (argument.length() > 0)
//                         {
//                             if(p.findObject(argument))
//                             {
//                                 try {
//                                     Object temp = p.getObject(argument);
//                                     temp.inspect();
//                                 } catch (Exception e){e.printStackTrace();}
//                             }
//                             else
//                             {
//                                this.notifyObservers("I couldn't find " + argument + " in my inventory.");
//                             }
//                         }
//                         else
//                         {
//                            this.notifyObservers("Inspect what?");
//                         }
//                         break;
//                     case "take":
//                         if (argument.length() > 0)
//                         {
//                             if(currentScene.findObject(argument))
//                             {
//                                 try {
//                                     (currentScene.getObject(argument)).take(p);
//                                 } catch (Exception e) {e.printStackTrace();}
//                             }
//                             else
//                             {
//                                this.notifyObservers("I couldn't find " + argument + " in the room.");
//                             }
//                         }
//                         else
//                         {
//                            this.notifyObservers("Take what?");
//                         }
//                         break;
//                     case "look":
//                         if (argument.equals("around"))
//                         {
//                             currentScene.printDescription();
//                         }
//                         break;
//                     case "inv":
//                     case "inventory":
//                         p.listInventory();
//                         break;
//                     case "exit":
//                         out.print("Are you sure you want to leave? [Y/N]: ");
//                         String answer = input.nextLine().trim().toLowerCase();
//                         if (answer.equals("y"))
//                         {
//                             //Exit message
//                            this.notifyObservers("Thank you for playing our game. Exiting...");
//                             input.close();
//                             System.exit(0);
//                         }
//                     default:
//                        this.notifyObservers("I don't know how to do that.");
//                 }
//             }

//             tick.tick();
//         }
//     }
// }
