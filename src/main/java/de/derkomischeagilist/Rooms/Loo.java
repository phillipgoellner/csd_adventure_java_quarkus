package de.derkomischeagilist.Rooms;

import de.derkomischeagilist.Location;

public class Loo extends AbstractRoom {

    private int toiletPaperCount;

    public Loo() {
        toiletPaperCount = 0;
    }

    public void resetCounter() {
        toiletPaperCount = 0;
    }

    @Override
    public Location getLocation() {
        return Location.LOO;
    }

    @Override
    public String getDescription() {
        return "You <b>wake up</b> on the loo. You have <b>no idea where or who you are</b>.";
    }

    @Override
    public String getDetailedDescription() {
        return "You see a pretty dirty door, with some nasty jokes on it. You're sitting on a toilet. There are three pieces of toilet paper on the ground. Next to you are a few magazines."
          + "<br/>"
          + "In your pocket you find a card that says you are a Pathetic Scrum Developer (PSD)."
          + "<br/>"
          + "When you look down, you see your dropped pants.";
    }

    @Override
    public String handleCommand(String command){
        switch(command.toLowerCase()) {
            case "look at magazines":
                return "You see a very much used Micky Mouse magazine, a very old and unusable playboy and what seems to be a scrum guide 2009 in mint condition.";
            case "look at toilet paper":
                toiletPaperCount++;
                switch (toiletPaperCount) {
                    case 1: return "On the first piece is written: \"Scrum Master: Nobody ever comes to my retros... I need to get out of here.\" There are more pieces on the ground.";
                    case 2: return "Another one states: \"A foo walks into a bar.\" More to read on the floor.";
                    case 3: return "Next piece says: \"Product Owner: My developers are way too slow.\" There is one more piece on the ground.";
                    case 4:
                        toiletPaperCount = 0;
                        return "On the last piece is written: \"Developers: We have too many meetings.\" I remember. I need to find my Scrum team to help them get out of here.";
                }
                case "go through door":
            case "flush toilet":
                return "Hsh, the stench has decreased drastically! You can breathe again :)";
            default:
                return
                   "you wake up on the Loo"
                   + "\n"
                   + super.handleCommand(command);
        }

    }

    @Override
    public String getHelp() {
        return "Try to 'look around', 'look at magazines' (better get your gloves), 'look at toilet paper', 'flush toilet' or just 'use door to washroom' to escape the smell." + super.getHelp();
    }
}
