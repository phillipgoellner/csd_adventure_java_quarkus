package de.derkomischeagilist;

import de.derkomischeagilist.Rooms.*;

import java.util.Locale;

public class Adventure {

    private int counter;
    protected Room currentRoom;
    private Loo loo;
    protected WashRoom washroom;
    private Hallway hallway;
    private TeamOffice teamOffice;
    private Kitchen kitchen;
    private String lastResponse;

    public Adventure() {
        loo = new Loo();
        washroom = new WashRoom();
        hallway = new Hallway();
        teamOffice = new TeamOffice();
        kitchen = new Kitchen();
        currentRoom = loo;
        counter = 0;
        lastResponse = "";
    }

    public String tell(String command) {
        String response = "";
        switch (command.toLowerCase()) {
            case "commit suicide":
                loo.resetCounter();
                currentRoom = loo;
                response = this.getBothDescriptions(currentRoom);
                break;
            case "read a joke":
                if (currentRoom == loo) {
                    response = "Why do we tell actors to 'break a leg?' - Because every play has a cast ;)";
                } else {
                    response = "There is no joke in this room.";
                }
                break;
            case "look around":
                response = currentRoom.getDetailedDescription();
                break;
            case "count":
                counter++;
                response = "The counter is at " + counter;
                break;
            case "use door to washroom":
                currentRoom = washroom;
                response = this.getBothDescriptions(currentRoom);
                break;
            case "use door to hallway":
                hallway.resetKeypad();
                currentRoom = hallway;
                response = this.getBothDescriptions(currentRoom);
                break;
            case "use door to loo":
                loo.resetCounter();
                currentRoom = loo;
                response = "You are on the loo again. Still smelly.";
                break;
            case "use door to team office":
                currentRoom = teamOffice;
                response = this.getBothDescriptions(currentRoom);
                break;
            case "use door to kitchen":
                currentRoom = kitchen;
                response = this.getBothDescriptions(currentRoom);
                break;
            case "help":
                response = currentRoom.getHelp();

                if (response == null || response.length() <= 0)
                    response = "There is no help for you!";

                break;
            default:
                if(command.isBlank()) {
                    response = lastResponse;
                    break;
                }
                response = currentRoom.handleCommand(command);
        }
        lastResponse = response;
        return response;
    }

    private String getBothDescriptions(Room room) {
        return room.getDescription() + "\n" + room.getDetailedDescription();
    }
   
    public String getActions() {
        return currentRoom.getHelp();
    }

    public String Begin() {
        lastResponse = currentRoom.getDescription();
        lastResponse += "\nIf you want to play the game, enter commands into the textbox.";
        return lastResponse;
    }

    public String whereAreWe() {
        Location location = currentRoom.getLocation();

        if (location != null) {
            return location.getName();
        } else {
            return "Unknown";
        }
    }
}
