package de.derkomischeagilist.Rooms;

import de.derkomischeagilist.Items.Cutlery;
import de.derkomischeagilist.Items.Dishwasher;
import de.derkomischeagilist.Items.Shower;

public class Kitchen implements Room {

    private Dishwasher dishwasher;
    private Shower shower;
    private int attemptsToShower;

    private Cutlery cutlery;
    private final SomeClassForDoingSomething peanuts;

    public Kitchen() {
        peanuts = new SomeClassForDoingSomething();
        this.shower = new Shower(Shower.CONDITION_DEFECT);
        this.dishwasher = new Dishwasher();
        this.attemptsToShower = 0;
        this.cutlery = new Cutlery(20);
    }

    @Override
    public String getDescription() {
        return "the kitchen";
    }

    @Override
    public String getDetailedDescription() {
        return "The room is very unclean. It might be the kitchen. It reminds you of home. There is a colleague standing in the corner on top of some pizza boxes. You see " + Integer.toString(this.cutlery.theTotalAmountOfKnivesThatAreInTheKitchenDisregardingTheirState) + " knives throughout the room. On the left side of the room you see a dishwasher in an awesome condition. On the other side of the room you can see the ancient remains of a shower. It's definitely the worst shower you've ever seen and you refuse to inspect it more in details. Something might be alive over there...";
    }

    @Override
    public String handleCommand(String command) {
        if ("clean kitchen".equals(command)) {
            return "you are very funny";
        }
        if("look at colleague".equals(command)) {
            return peanuts.developAProgram();
        }
        if ("do the knives fit into dishwasher".equals(command)) {
            return dishwasher.couldLoadCutlery(this.cutlery) ? "they could fit" : "eeerp - overload!";
        }
        if ("turn on the shower".equals(command)) {
            if (attemptsToShower > 0) {
             return "NO WAY! OTHERWISE I WILL VOMIT OUT MY SOUL...THIS ROTTEN STENCH...";
            }
            attemptsToShower += 1;
            return "It smells like something is rotten down in the sewer...";
        }
        return "öhm...";
    }

    private void attemptToShower() {
        attemptsToShower += 1;
        this.shower.notifyAll();
        while (shower.isTurnedOn() && (dishwasher.getMaxNumberOfPlates() > dishwasher.getCurrentNumberOfCleanKnivesLoaded())) {
            dishwasher.startCleaningAllLoadedDirtyPlatesAndCupsAndForksAndKnivesAndSpoonsAndTeaspoons();
        }
    }

    @Override
    public String getHelp() {
        return "help in the kitchen is useless";
    }

    class SomeClassForDoingSomething {
        PointsAndStuff h = new PointsAndStuff();
        String developAProgram() {
            return "Pizza The Hut is greeting you friendly:" + this.removeKommasAndDots();
        }

        private String removeKommasAndDots() {
            return h.thing() + b() +  h.thing() + a() + z() + new PointsAndStuff().punkt() + h.thing();
        }

        private String b () {
            return "d" + x() + "sugfls";
        }

        private String a () {
            return "omnse" + x() + "aähxx" + " ";
        }

        private String z () {
            return "kjshhyy" + x() + "k";
        }

        private String x () {
            return "i";
        }

    }

    class PointsAndStuff {
        private int counter = 1;

        public String punkt() {
            return "!";
        }

        public String thing() {
            if (counter++ % 2 == 0) {
                return " ";
            }
            return "'";
        }
    }
}
