package de.derkomischeagilist.Rooms;

import de.derkomischeagilist.Location;

public class TeamOffice extends AbstractRoom {

    public boolean coinPickedUp = false;
    public boolean lookedAtEmptyCubicle = false;

    @Override
    public Location getLocation() {
        return Location.TEAM_OFFICE;
    }

    @Override
    public String getDescription() {
        return "This is a very stinky room. Smells like real work and you can feel the Cold atmosphere inside the room. \n" +
        		"In the middle of the room there are several dirty old cubicles. " +
                "Nearly each one of the cubicles has a worker in front of it staring directly at the computer screen. \n" +
                "Your smart but smelly Teammates greet you in the usual manner: 'Hey, you moron! ;)', " +
                "one of the cubicles seems empty, might be yours.";
    }

    @Override
    public String getDetailedDescription() {  
        return "You see many flip charts, sticky notes and other things on the wall. In the corner, you spot an ancient jukebox.";
    }

    public String getEmptyCubicleDescription() {
        String description =  "You recognise your cubicle. " +
            "All the papers and the pain are still where you left them. " +
            "A half-eaten bar of Scrum Company chocolate lies next to the crusty keyboard, as do a couple of pens with half-bitten tips. ";
        
        if(!coinPickedUp) {
            description += "A small coin is being used to prop up the monitor, might be useful somewhere else. ";
        }
        
        return description +
            "You can also see a used handkerchief covering part of the monitor, though strangely enough you can't tell the pattern.";
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
            return "You've picked up your coin.";
        } else {
            return "You already have picked up your coin.";
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
        if(command.equals("look at jukebox")) {
            return "The jukebox looks old, but might be operational. Its chrome edges slightly tarnished but still gleaming under the soft glow of vintage bulbs. Behind scratched glass you see a list of old songs.";  
        }
        if(command.equals("pick up coin")) {
            return getCoin();
        }
        if(command.equals("pick up handkerchief")) {
            return "Ew.";
        }
        if(command.equals("look at empty cubicle")) {
            lookedAtEmptyCubicle = true;
            return getEmptyCubicleDescription();
        }
    	else return super.handleCommand(command);
    }

    @Override
    public String getHelp() {
        String helpText = "Try to type 'look around', 'look at first cubicle', 'look at empty cubicle', 'look at wall', 'look at jukebox'";

        if(lookedAtEmptyCubicle && !coinPickedUp) {
            helpText += ", 'pick up coin', 'pickup handkerchief'";
        }

        return helpText + " or 'use door to hallway'" + "<br/>" + super.getHelp();
    }
}
