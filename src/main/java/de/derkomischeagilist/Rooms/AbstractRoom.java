package de.derkomischeagilist.Rooms;

public abstract class AbstractRoom implements Room {
    @Override
    public String handleCommand(String command) {
        return String.format("Sorry, I don't understand '%s'" +
                "<br /><br />", command);
    }

    @Override
    public String getHelp() {
        return "If you want to restart, just try to 'restart drinking'.";
    }
}
