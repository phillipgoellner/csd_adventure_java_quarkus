package de.derkomischeagilist;

import de.derkomischeagilist.Rooms.*;

import java.util.Locale;

public class Adventure {

    private int counter;
    protected Room currentRoom;
    private Loo loo;
    protected Room washroom;
    private Room hallway;
    private Room teamOffice;
    private Room kitchen;
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
                response = currentRoom.getDescription();
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
                response = currentRoom.getDescription();
                break;
            case "use door to hallway":
                currentRoom = hallway;
                response = currentRoom.getDescription();
                break;
            case "use door to loo":
                loo.resetCounter();
                currentRoom = loo;
                response = "You are on the loo again. Still smelly.";
                break;
            case "use door to team office":
                currentRoom = teamOffice;
                response = currentRoom.getDescription();
                break;
            case "use door to kitchen":
                currentRoom = kitchen;
                response = currentRoom.getDescription();
                break;
            case "help":
                response = currentRoom.getHelp();

                if (response == null || response.length() <= 0)
                    response = "There is no help for you!";

                break;
            default:
                return currentRoom.handleCommand(command);
        }
        lastResponse = response;
        return response;
    }

    public String Begin() {
        lastResponse = currentRoom.getDescription();
        return currentRoom.getDescription();
    }
}
