package de.derkomischeagilist.Rooms;

public class TeamOffice extends AbstractRoom {
    @Override
    public String getDescription() {
        return "This is a very stinky room. Smells like real work. \n" +
                "Your smart but smelly Teammates greet you in the usual manner: 'Hey, you moron! ;)'";
    }

    @Override
    public String getDetailedDescription() {  
        return "You see many flip charts, sticky notes and other things on the walls.";
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
