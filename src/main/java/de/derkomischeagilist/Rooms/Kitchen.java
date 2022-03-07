package de.derkomischeagilist.Rooms;

import de.derkomischeagilist.Items.Cutlery;
import de.derkomischeagilist.Items.Dishwasher;
import de.derkomischeagilist.Items.Shower;

public class Kitchen implements Room {

    private Dishwasher dishwasher;
    private Shower shower;

    private Cutlery cutlery;
    private final SomeClassForDoingSomething peanuts;

    public Kitchen() {
        peanuts = new SomeClassForDoingSomething();
        this.dishwasher = new Dishwasher();

        this.cutlery = new Cutlery(20);
    }

    @Override
    public String getDescription() {
        return "the kitchen";
    }

    @Override
    public String getDetailedDescription() {
        return "The room is very unclean. It might be the kitchen. It reminds you of home. There is a colleague standing in the corner on top of some pizza boxes. You see " + Integer.toString(this.cutlery.theTotalAmountOfKnivesThatAreInTheKitchenDisregardingTheirState) + " knives throughout the room.";
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
        return "öhm...";
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
