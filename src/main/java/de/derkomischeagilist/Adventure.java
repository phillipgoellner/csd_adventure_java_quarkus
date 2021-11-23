package de.derkomischeagilist;

import de.derkomischeagilist.Rooms.Loo;
import de.derkomischeagilist.Rooms.Room;

public class Adventure {

    private int counter;
    private Room room;
    private String lastResponse;

    public Adventure() {
        room = new Loo();
        counter = 0;
        lastResponse = "";
    }

    public String tell(String command) {
        String response = "";
        switch (command){
            case "look around":
                response = room.getDetailedDescription();
                break;
            case "look at magazines":
                response = "You see a very much used Micky Mouse magazine, a very old and unusable playboy and what seems to be a scrum guide 2009 in mint condition.";
                break;
            case "count":
                counter++;
                response = "The counter is at " + counter;
                break;
            default:
               return room.handleCommand(command);
        }
        lastResponse = response;
        return response;
    }

    public String Begin() {
        lastResponse = room.getDescription();
        return room.getDescription();
    }
}
