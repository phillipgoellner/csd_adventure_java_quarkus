package de.derkomischeagilist.Rooms;

import de.derkomischeagilist.Location;

public interface Room {

    Location getLocation();

    String getDescription();

    String getDetailedDescription();

    String handleCommand(String command);

    String getHelp();
}
