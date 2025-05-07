package de.derkomischeagilist.Rooms;

import de.derkomischeagilist.Location;

public class TeamOffice extends AbstractRoom {

    private boolean coinPickedUp = false;

    @Override
    public Location getLocation() {
        return Location.TEAM_OFFICE;
    }

    @Override
    public String getDescription() {
        return "This is a very stinky room. Smells like real work and you can feel the Cold atmosphere inside the room. \n" +
        		"In the middle of the room there are several dirty old cubicles. " +
                "Nearly each one of the cubicles has a worker in front of it staring directly at the computer screen. \n" +
                "Your smart but smelly Teammates greet you in the usual manner: 'Hey, you moron! ;)'";
    }

    @Override
    public String getDetailedDescription() {  
        return "You see many flip charts, sticky notes and other things on the wall.";
    }

    private String getBurndownChart() {
        return          "Among many unintelligible Sticky Notes, you see a big flip chart with a note added:\n\n" +
                        "Note from Management: Impressive! Your Burndown Chart resists all forms of gravity!\n\n" +
                        "<pre>\n" +
                        " 10 |-------------------------------------------------------------\n" +
                        "    |                                          \n" +
                        "  8 |                                          \n" +
                        "    |                                          \n" +
                        "  6 |                                          \n" +
                        "    |                                          \n" +
                        "  4 |                                          \n" +
                        "    |                                          \n" +
                        "  2 |                                          \n" +
                        "    |                                          \n" +
                        "    --------------------------------------------------------------\n" +
                        "       Day 1    Day 2    Day 3    Day 4    Day 5    Day 6    Day 7\n" +
                        "</pre>";
    }

    private String getCoin() {
        if (!coinPickedUp) {
            coinPickedUp = true;
            return "You've picked your coin.";
        } else {
            return "You already picked up your coin.";
        }
    }

    @Override
    public String handleCommand(String command) {
        if(command.equals("look at first cubicle")) {
            return "Hey! I am Homer!";
        }
        if(command.equals("look at wall")) {
            return getBurndownChart();
        }
        if(command.equals("pickup coin")) {
            return getCoin();
        }
    	else return super.handleCommand(command);
    }

    @Override
    public String getHelp() {
        return "Try to type 'look around', 'look at first cubicle', 'look at wall' or 'use door to hallway'." + "<br/>"
        + super.getHelp();
    }
}
