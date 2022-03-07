package de.derkomischeagilist.Rooms;

import de.derkomischeagilist.Items.Dishwasher;

public class Kitchen implements Room {

    private Dishwasher dishwasher;

    @Override
    public String getDescription() {
        return "the kitchen";
    }

    @Override
    public String getDetailedDescription() {
        return "the very unclean kitchen";
    }

    @Override
    public String handleCommand(String command) {
        if ("clean kitchen".equals(command)) {
            return "you are very funny";
        }
        return "öhm...";
    }

    @Override
    public String getHelp() {
        return "help in the kitchen is useless";
    }
}
