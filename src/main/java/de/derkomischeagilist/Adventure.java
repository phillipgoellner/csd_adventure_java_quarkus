package de.derkomischeagilist;

import de.derkomischeagilist.Rooms.Loo;
import de.derkomischeagilist.Rooms.Room;
import de.derkomischeagilist.Rooms.WashRoom;

public class Adventure {

    private int counter;
    private Room currentRoom;
    private Room loo;
    private Room washroom;
    private String lastResponse;

    public Adventure() {
        loo = new Loo();
        washroom = new WashRoom();
        currentRoom = loo;
        counter = 0;
        lastResponse = "";
    }

    public String tell(String command) {
        String response = "";
        switch (command){
            case "look around":
                response = currentRoom.getDetailedDescription();
                break;
            case "count":
                counter++;
                response = "The counter is at " + counter;
                break;
            case "go through door":
                currentRoom = washroom;
                response = currentRoom.getDescription();
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
