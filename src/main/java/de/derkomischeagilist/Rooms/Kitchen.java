package de.derkomischeagilist.Rooms;

import de.derkomischeagilist.Items.Dishwasher;
import de.derkomischeagilist.Items.Shower;

public class Kitchen implements Room {

    private Dishwasher dishwasher;
    private Shower shower;

    @Override
    public String getDescription() {
        return "the kitchen";
    }

    @Override
    public String getDetailedDescription() {
        return "The room is very unclean. It might be the kitchen. It reminds you of home. There is a colleague standing in the corner on top of some pizza boxes.";
    }

    @Override
    public String handleCommand(String command) {
        if ("clean kitchen".equals(command)) {
            return "you are very funny";
        }
        if("look at colleague".equals(command)) {
            return new PizzaTheHut().developAProgram();
        }
        return "öhm...";
    }

    @Override
    public String getHelp() {
        return "help in the kitchen is useless";
    }

    class PizzaTheHut {
        String developAProgram() {
            return "Pizza The Hut is greeting you friendly:" + this.removeKommasAndDots();
        }

        private String removeKommasAndDots() {
            return "'disugfls omnseeaähxx kjshhyyyk!'";
        }
    }
}
