package de.derkomischeagilist.Rooms;

import de.derkomischeagilist.Location;

public class TeamOffice extends AbstractRoom {

    @Override
    public Location getLocation() {
        return Location.TEAM_OFFICE;
    }

    @Override
    public String getDescription() {
        return "This is a very stinky room. Smells like real work and you can feel the Cold atmosphere inside the room. \n" +
        		"In the middle of the room there are several dirty old cubicles. Nearly each one of the cubicles has a worker in front of it staring directly at the computer screen. \n" +
                "Your smart but smelly Teammates greet you in the usual manner: 'Hey, you moron! ;)'";
    }

    @Override
    public String getDetailedDescription() {  
        return "You see many flip charts, sticky notes and other things on the walls. \n" +
                "One wall holds a burndown chart. Its line is horizontal! Seems that the team does not finish anything ;) -> Close your PBI´s";
    }

    @Override
    public String handleCommand(String command) {
    	if(command.equals("look at stickies")) {
    		return "You see a sticky with what I hated about the last sprint review. \n Took endless time. \n Technical problems. \n Customer requirements not met.";
    	}
    	else return super.handleCommand(command);
    }

    @Override
    public String getHelp() {
        return "Try to type 'look around' or 'use door to hallway'." + super.getHelp();
    }
}
