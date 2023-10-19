package de.derkomischeagilist.Rooms;

public class WashRoom extends AbstractRoom {

    public String getDescription() {
        return "You enter a room that looks like a wash room.";
    }

    public String getDetailedDescription() {
        return "You see an incredibly nasty sink with an undefinable substance in it. Ew!"
                + "<br/>"
                + "You notice a DoD on the door."
                + "</br>"
                + "On the other side of the room you see another door.";
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
                return "Unfortunately the soap dispenser is empty :( So you wash your hands only with hot water.";
            case "put paper towels in the bin":
                return "Bin has been filled with used paper towels. Now the bin is overflowing with even more dirty paper towels.";
            default:
                return super.handleCommand(command);
        }
    }

    @Override
    public String getHelp() {
        return "Try to type 'look around', 'read DoD', 'use door to hallway', 'use door to loo', 'put paper towels in the bin' or 'wash hands'." + super.getHelp();
    }
}
