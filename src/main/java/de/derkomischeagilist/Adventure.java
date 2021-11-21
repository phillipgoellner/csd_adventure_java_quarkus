package de.derkomischeagilist;

import de.derkomischeagilist.Rooms.Loo;

public class Adventure {

    private int counter;
    private Loo room;
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
                response = room.DetailedDescription();
                break;
            case "look at magazines":
                response = "You see a very much used Micky Mouse magazine, a very old and unusable playboy and what seems to be a scrum guide 2009 in mint condition.";
                break;
            case "count":
                counter++;
                response = "The counter is at " + counter;
                break;
            default:
               return lastResponse + "\n\nWhat???";
        }
        lastResponse = response;
        return response;
    }

    public String Begin() {
        lastResponse = room.Description();
        return room.Description();
    }
}
