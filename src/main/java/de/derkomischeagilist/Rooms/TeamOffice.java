package de.derkomischeagilist.Rooms;

import de.derkomischeagilist.Inventory;
import de.derkomischeagilist.Location;

public class TeamOffice extends AbstractRoom {

    public boolean lookedAtEmptyCubicle = false;
    public boolean lookedAtJukeBox = false;
    private final Inventory inventory = Inventory.getInstance();

    @Override
    public Location getLocation() {
        return Location.TEAM_OFFICE;
    }

    public void resetRoom() {
        lookedAtEmptyCubicle = false;
    }

    @Override
    public String getDescription() {
        return "This is a very stinky room. Smells like real work and you can feel the cold atmosphere inside the room. \n" +
        		"In the middle of the room there are several dirty old cubicles. " +
                "Nearly each one of the cubicles has a worker in front of it staring directly at the computer screen. \n" +
                "Your smart but smelly Teammates greet you in the usual manner: 'Hey, you moron! ;)', " +
                "one of the cubicles seems empty, might be yours.";
    }

    @Override
    public String getDetailedDescription() {
        return "You see many flip charts, sticky notes and other things on the wall. In the corner, you spot an ancient jukebox.";
    }

    public String getEmptyCubicleDescription() {
        String description = "You recognise your cubicle. " +
                "All the papers and the pain are still where you left them. " +
                "A half-eaten bar of Scrum Company chocolate lies next to the crusty keyboard, as do a couple of pens with half-bitten tips. ";

        if (!inventory.hasItem("coin")) {
            description += "A small coin is being used to prop up the monitor, might be useful somewhere else. ";
        }

        return description +
                "You can also see a used handkerchief covering part of the monitor, though strangely enough you can't tell the pattern.";
    }

    private String getBurndownChart() {
        return "Among many unintelligible Sticky Notes, you see a big flip chart with a note added:\n\n" +
                "Note from Management: Impressive! Your Burndown Chart resists all forms of gravity!\n\n" +
                "<pre>\n" +
                " 10 |-------------------------------------------------------------\n" +
                "    |                                          \n" +
                "  8 |                                          \n" +
                "    |                                          \n" +
                "  6 |                                          \n" +
                "    |                                          \n" +
                "  4 |                                          \n" +
                "    |                                          \n" +
                "  2 |                                          \n" +
                "    |                                          \n" +
                "    --------------------------------------------------------------\n" +
                "       Day 1    Day 2    Day 3    Day 4    Day 5    Day 6    Day 7\n" +
                "</pre>";
    }

    private String getCoin() {
        if (!inventory.hasItem("coin")) {
            inventory.addItem("coin");
            return "You've picked up your coin.";
        } else {
            return "You already have picked up your coin.";
        }
    }

    @Override
    public String handleCommand(String command) {
        switch (command) {
            case "look at first cubicle":
                return "Hey! I am Homer!";
            case "look at wall":
                return getBurndownChart();
            case "look at jukebox":

                lookedAtJukeBox = true;

                return "The jukebox looks old, but might be operational. Its chrome edges slightly tarnished but still gleaming under the soft glow of vintage bulbs. Behind scratched glass you see a list of old songs.<br>" +
                        "<br>" +
                        "11. Oh Happy Day<br>" +
                        "13. Under Pressure<br>" +
                        "19. Yellow Submarine<br>" +
                        "20. All You Need Is Love<br>" +
                        "<br>";
            case "pick up coin":
                return getCoin();
            case "pick up handkerchief":
                return "Ew.";
            case "look at empty cubicle":
                lookedAtEmptyCubicle = true;
                return getEmptyCubicleDescription();
            case "insert coin": if (inventory.hasItem("coin")) {
                inventory.removeItem("coin");
                return "After you inserted the coin, you see the dirty looking keys lighting up, below you can choose a song, by entering the songnumber";
            } else return "You are searching your pockets for a coin, but unfortunately you don't have one with you.";

            default:
                if(lookedAtJukeBox){
                    if(command.startsWith("play song")){
                        int songNumber = Integer.parseInt(command.replace("play song", "").trim());
                        switch (songNumber) {
                            case 11: {
                                return "♩ ♪ ♩ ♫ ♩ ♫ ♪ ♩ ♩ ♫ \n" +
                                        " \n" +
                                        "The jukebox hums softly as a familiar melody begins to fill the room...\n" +
                                        " \n" +
                                        "♩ ♩ ♪ ♫ ♩ ♫ ♪ ♫ ♩ ♩  \n" +
                                        " \n" +
                                        "Oh happy day\n" +
                                        "(Oh happy day)\n" +
                                        "Oh happy day\n" +
                                        "(Oh happy day)\n" +
                                        "When Jesus washed\n" +
                                        "Oh when he washed\n" +
                                        "When Jesus washed\n" +
                                        "He washed the sins away\n" +
                                        "Oh happy day\n" +
                                        "(Oh happy day)\n" +
                                        "Oh happy day\n" +
                                        "(Oh happy day)\n";
                            }
                            case 13: {
                                return "♩ ♪ ♩ ♫ ♩ ♫ ♪ ♩ ♩ ♫ \n" +
                                        " \n" +
                                        "The jukebox hums softly as a familiar melody begins to fill the room...\n" +
                                        " \n" +
                                        "♩ ♩ ♪ ♫ ♩ ♫ ♪ ♫ ♩ ♩  \n" +
                                        " \n" +
                                        "Pressure pushing down on me\n" +
                                        "Pressing down on you, no man ask for\n" +
                                        "Under pressure that burns a building down\n" +
                                        "Splits a family in two\n" +
                                        "Puts people on streets\n" +
                                        "\n" +
                                        "That′s OK";
                            }
                            case 19: {
                                return "♩ ♪ ♩ ♫ ♩ ♫ ♪ ♩ ♩ ♫ \n" +
                                        " \n" +
                                        "The jukebox hums softly as a familiar melody begins to fill the room...\n" +
                                        " \n" +
                                        "♩ ♩ ♪ ♫ ♩ ♫ ♪ ♫ ♩ ♩  \n" +
                                        " \n" +
                                        "In the town where I was born\n" +
                                        "Lived a man who sailed to sea\n" +
                                        "And he told us of his life\n" +
                                        "In the land of submarines";
                            }
                            case 20: {
                                return "♩ ♪ ♩ ♫ ♩ ♫ ♪ ♩ ♩ ♫ \n" +
                                        " \n" +
                                        "The jukebox hums softly as a familiar melody begins to fill the room...\n" +
                                        " \n" +
                                        "♩ ♩ ♪ ♫ ♩ ♫ ♪ ♫ ♩ ♩  \n" +
                                        " \n" +
                                        "Love, love, love\n" +
                                        "Love, love, love\n" +
                                        "Love, love, love\n" +
                                        "There's nothing you can do that can't be done\n" +
                                        "Nothing you can sing that can't be sung\n" +
                                        "Nothing you can say, but you can learn\n" +
                                        "How to play the game\n" +
                                        "It's easy";
                            }
                            default:
                                return "You press the buttons, but nothing happens. The jukebox makes a quiet buzz and shows a message: “TRACK NOT FOUND“";
                        }
                    }
                }
                return super.handleCommand(command);
        }
    }

    @Override
    public String getHelp() {
        String helpText = "Try to type 'look around', 'look at first cubicle', 'look at empty cubicle', 'look at wall', 'look at jukebox'";

        if (lookedAtEmptyCubicle && !inventory.hasItem("coin")) {
            helpText += ", 'pick up coin', 'pick up handkerchief'";
        }

        if (inventory.hasItem("coin") && lookedAtJukeBox) {
            helpText += ", 'insert coin'";
        }

        if (lookedAtJukeBox) {
            helpText += ", 'play song [number]'";
        }

        return helpText + " or 'use door to hallway'" + " " + super.getHelp();
    }
}
