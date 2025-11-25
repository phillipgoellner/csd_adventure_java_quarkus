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
                        "23. All you need is Love<br>" +
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
                            case 10: {
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
                                         "Here comes the sun, doo-doo-doo\n" +
                                        "Here comes the sun\n" +
                                        "And I say, It's all right\n" +
                                        "Little darlin'\n" +
                                        "It's been a long, cold, lonely winter\n" +
                                        "Little darlin'\n" +
                                        "It feels like years since it's been here";
                            }
                            case 19: {
                                return "♩ ♪ ♩ ♫ ♩ ♫ ♪ ♩ ♩ ♫ \n" +
                                        " \n" +
                                        "The jukebox hums softly as a familiar melody begins to fill the room...\n" +
                                        " \n" +
                                        "♩ ♩ ♪ ♫ ♩ ♫ ♪ ♫ ♩ ♩  \n" +
                                        " \n" +
                                        "Is this the real life? Is this just fantasy?\n" +
                                        "Caught in a landslide, no escape from reality\n" +
                                        "Open your eyes, look up to the skies and see\n" +
                                        "I'm just a poor boy, I need no sympathy\n" +
                                        "Because I'm easy come, easy go\n" +
                                        "Little high, little low\n" +
                                        "Any way the wind blows doesn't really matter to me, to me";
                            }
                            case 23: {
                                return "♩ ♪ ♩ ♫ ♩ ♫ ♪ ♩ ♩ ♫ \n" +
                                        " \n" +
                                        "The jukebox hums softly as a familiar melody begins to fill the room...\n" +
                                        " \n" +
                                        "♩ ♩ ♪ ♫ ♩ ♫ ♪ ♫ ♩ ♩  \n" +
                                        " \n" +
                                        "Tonight\n" +
                                        "I'm gonna have myself a real good time\n" +
                                        "I feel alive\n" +
                                        "And the world, I'll turn it inside out, yeah\n" +
                                        "I'm floating around in ecstasy, so\n" +
                                        "Don't stop me now\n" +
                                        "Don't stop me\n" +
                                        "'Cause I'm having a good time, having a good time\n" +
                                        "I'm a shooting star leaping through the sky like a tiger\n" +
                                        "Defying the laws of gravity\n" +
                                        "I'm a racing car, passing by like Lady Godiva\n" +
                                        "I'm gonna go, go, go, there's no stopping me";
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
