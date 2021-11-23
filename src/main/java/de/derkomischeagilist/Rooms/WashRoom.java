package de.derkomischeagilist.Rooms;

public class WashRoom implements Room {

    public String getDescription() {
        return "You enter a room that looks like a wash room.";
    }

    public String getDetailedDescription() {
        return "You see an incredibly nasty sink with an undefinable substance in it. Ew!"
          + "<br/>"
          + "On the other side of the room you see another door";
    }

    public String handleCommand(String command){
        return "What???";
    }

    @Override
    public String getHelp() {
        return null;
    }
}
