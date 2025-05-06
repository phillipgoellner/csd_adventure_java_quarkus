package de.derkomischeagilist.Rooms;

import de.derkomischeagilist.Location;

public class WashRoom extends AbstractRoom {

    @Override
    public Location getLocation() {
        return Location.WASHROOM;
    }

    private boolean areHandsWashed = false;

    public String getDescription() {
        return "You enter a room that looks like a wash room.";
    }

    public String getDetailedDescription() {
        return "You see an incredibly nasty sink with an undefinable substance in it. Ew!"
                + "<br/>"
                + "You notice a DoD on the door."
                + "</br>"
                + "On the other side of the room you see the door that leads to the loo.";
    }

    public String handleCommand(String command) {
        switch (command.toLowerCase()) {
            case "read dod":
                return "hands washed?" +
                        "</br>" +
                        "paper towels in bin?" +
                        "</br>" +
                        "toilet flushed?";
            case "wash hands":
                areHandsWashed = true;
                return "Oh WOW!!! The soap dispenser is full :) So you happily wash your hands with hot water and soap.";
            case "put paper towels in the bin":
                return "The bin is as always overflowing... Somehow you manage to stuff the dirty paper towels in the bin.";
            default:
                return super.handleCommand(command);
        }
    }

    @Override
    public String getHelp() {
        return "Try to type 'look around', 'read DoD', 'use door to hallway', 'use door to loo', 'put paper towels in the bin' or 'wash hands'." + "<br/>"+ super.getHelp();
    }

    public boolean getAreHandsWashed() {
        return areHandsWashed;
    }

    public void setAreHandsWashed(boolean areHandsWashed) {
        this.areHandsWashed = areHandsWashed;
    }
}
