package de.derkomischeagilist.Rooms;

public class Hallway extends AbstractRoom {
    @Override
    public String getDescription() {
        return "Welcome to the hallway to hell.";
    }

    @Override
    public String getDetailedDescription() {
        return "Welcome to the very dark hallway to hell. At the end you see a spooky looking door.";
    }

    @Override
    public String handleCommand(String command) {
        switch (command) {
            case "inspect the spooky door":
                return "You see a rugged and sturdy steel door with cryptic symbols on it. The door is covered in cobweb and next to it is a rusty keypad. If you feel brave enough you could 'open the spooky door'?";
            case "open the spooky door":
                return "It seems locked and doesn't budge.";
            default: return super.handleCommand(command);
        }
    }

    @Override
    public String getHelp() {
        return super.getHelp()+ "Try to 'look around' or 'use door to team office'. You can also 'go through door' to go to the washroom or 'use door to kitchen' to visit pizza the hut or maybe try to 'inspect the spooky door'.";
    }
}
