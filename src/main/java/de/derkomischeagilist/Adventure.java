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
            case "look at magazines":
                response = "You see a very much used Micky Mouse magazine, a very old and unusable playboy and what seems to be a scrum guide 2009 in mint condition.";
                break;
            case "count":
                counter++;
                response = "The counter is at " + counter;
                break;
            case "goto washroom":
                currentRoom = washroom;
                response = currentRoom.getDescription();
                break;
            default:
               return lastResponse + "\n\nWhat???";
        }
        lastResponse = response;
        return response;
    }

    public String Begin() {
        lastResponse = room.getDescription();
        return room.getDescription();
    }
}
