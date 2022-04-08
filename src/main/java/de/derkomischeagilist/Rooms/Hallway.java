package de.derkomischeagilist.Rooms;

public class Hallway implements Room {
    @Override
    public String getDescription() {
        return "Welcome to the hallway to hell.";
    }

    @Override
    public String getDetailedDescription() {
        return "Welcome to the very dark hallway to hell.";
    }

    @Override
    public String handleCommand(String command) {
        return null;
    }

    @Override
    public String getHelp() {
        return "Try to 'look around' or 'use door to team office'. You can also 'go through door' to go to the washroom or 'use door to kitchen' to visit pizza the hut.";
    }
}
