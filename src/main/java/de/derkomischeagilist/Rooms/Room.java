package de.derkomischeagilist.Rooms;

import java.util.List;

public interface Room {

    String getDescription();

    String getDetailedDescription();

    String handleCommand(String command);

    String getHelp();
}
