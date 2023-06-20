package de.derkomischeagilist.Rooms;

public abstract class AbstractRoom implements Room {
    @Override
    public String handleCommand(String command) {
        return String.format("Did you just ask me to '%s'?" +
                "<br /><br />" +
                "404 - command not found. %s", command, this.getHelp());
    }

    @Override
    public String getHelp() {
        return " If you want to restart, just try to 'commit suicide'.";
    }
}
