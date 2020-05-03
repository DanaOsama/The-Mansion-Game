# Our glorious project

## Characters
- Butler (Found at the main door)
  - In the first interaction, the butler tells a player an ominous story about how they must escape this house only by collecting 7 keys
  - Every interaction after that, the butler will pick a random ominous line and say it
  - For each key the player gets, the butler takes the key and in return will get something from the butler (Plus his lines will change now)
  - The butler never moves from the main door
- Suhaib (Trapped in the basement initially)
  - In the first interaction, suhaib is screaming for help and tells the player that they need the combination to the lock on the door
  - Every interaction after that, suhaib will just endlessly scream for help and may call the player stupid if they are a girl
  - Once freed, suhaib will give a key he "thought was useless" to the player, earning them one of the needed keys to finish the game
  - Suhaib will then proceed to appear in different rooms throughout the game and says random lines when approached.
  - Suhaib introduces himself to the player as a computer engineer, which is important as suhaib can help the player get a key faster (By reparing the old radio).
- The Masked Writer (Found in the Study)
  - The Masked Writer is only found in their room at night. First interaction will be the Masked Writer noticing the player, then rushing at them causing the player to immediately flee the room. 
  - The player will note to self to ask the butler about the masked writer. Once asked, the butler will reveal that the masked writer only sits in their office at night. To get into the office, the butler will tell you to talk to him in the morning.
  - Once in the morning, the butler will let you into the room. The player will have until the night tick to figure out how to open the drawer containing another key. There is a word combination lock on the drawer and to open it, the player must answer a riddle.
  - If the player fails to get the key and is still inside the room once the night cycle kicks in, the masked writer will appear and attack the player. Sending them back to the main entrance.
  - If the player gets the key successfully, if they encounter the masked writer once again they will no longer attack the player.


## Game features
- [ ] (BONUS) Day and Night cycle
- [ ]  


## Locations
---
### **Supply Room**

*Initial State*
- **Note:**  explains the game commands and the situation
- **Book:** has the key inside it. It is initally on a bookshelf. 
- **Key:** unlocks the door to the main entrance.
- **Pocket watch:** helps the player identify time. Especially useful when trying to access the study when the masked writer is not there.
- **Bucket**: put under a spot where water is dripping from the ceiling. the bucket is full of water. Used to cool the axe down. 

### **Secret Room**
*Locked*

### **Main Entrance**
*Initally locked. Will be unlocked after finding the key in the supply room.*
- **Chest:** Has one golden key. It is locked by a five-letter combination pin. The riddle to unlock the chest is in the living room's notice board.

### **Dining Room**
*Initally unlocked.*

- **Fireplace:** the fireplace is burning bright. There is a glowing axe burning inside.
- **Fireplace poker:** Used to push the axe out of the fireplace.
- **Axe:** used to open the boarded up kitchen.

### **Kitchen**
*boarded up*
- **Flashlight:** used to "unlock" stairs, therefore unlocking the cellar and the living room.
- **matches**: used to burn cobwebs that lock the cellar.

### **Cellar**
 - **Suhaib:** is locked in the cellar. Will give one key once freed.
### **Stairs**
*just a virtual room to lead upstairs and downstairs*
### **Study** 
    
### **Living Room**

## Player behavior
- When a player loses a life (by getting attacked or eating something poisonois for example), they spawn back at the main entrance of the castle
- When a player eats something 'healthy', they gain a life. You can only have a maximum of 4 lives at a time.
- Player can pick up stuff and put it in the inventory
- Player can talk to characters

## Singleton Pattern
Scenes and the player implement this pattern.s

## Command Pattern
Our main contains a loop and a parser (still dont know if its a class). Our main reads different commands and executes them with the proper context.

Psuedo code:
```js
input = readInput();
command = input.split(" ")[0];
object = input.split(" ")[1];

switch (command)
{
  case "help":
    //do help
    break;
  case "use":
    //some checks first
    if (checkInventory(object, player))
    {
      //stuff
    } else if (checkRoom(object, player))
    {
      //stuff
    }
    else
    {
      print(object + " is not in the room nor your inventory!");
    }
    break;
  default:
    print("Invalid command. Use 'HELP' to list commands.")
}
```

## Commands
- use (object)
- take (object)
- eat (object)
- go (direction)
- talk to (character)
- read (object)
- look around
- look at (object)
- inventory 
- status [status and any ongoing effects]
- rest (auto skips to the next day/night cycle)
- help

## Classes w/ Notes

### Ticker.java
- should not count invalid syntax as a tick.
- each 20 ticks counts as a day/night cycle

