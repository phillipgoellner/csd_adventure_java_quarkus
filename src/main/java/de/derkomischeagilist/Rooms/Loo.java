package de.derkomischeagilist.Rooms;

public class Loo implements Room {

    @Override
    public String getDescription() {
        return "You wake up on the loo. You have no idea where or who you are.";
    }

    @Override
    public String getDetailedDescription() {
        return "You see a pretty dirty door, with some nasty jokes on it. Next to you is some toilet paper, a coin and a few magazines."
          + "<br/>"
          + "In your pocket you find a card that says you are a certified scrum developer";
    }

    @Override
    public String handleCommand(String command){
        return null;
    }

    @Override
    public String getHelp() {
        return null;
    }
}
