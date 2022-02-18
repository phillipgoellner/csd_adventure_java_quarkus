package de.derkomischeagilist.Rooms;

public class TeamOffice implements Room {
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
        return null;
    }

    @Override
    public String getHelp() {
        return null;
    }
}
