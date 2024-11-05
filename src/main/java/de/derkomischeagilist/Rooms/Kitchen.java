package de.derkomischeagilist.Rooms;

import de.derkomischeagilist.Colleagues.PizzaTheHut;
import de.derkomischeagilist.Items.CoffeeMaker;
import de.derkomischeagilist.Items.Cutlery;
import de.derkomischeagilist.Items.Dishwasher;
import de.derkomischeagilist.Items.Shower;
import de.derkomischeagilist.Location;
import de.derkomischeagilist.TimeService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Kitchen extends AbstractRoom {

    private Dishwasher dishwasher;
    private Shower shower;
    private int attemptsToShower;
    private CoffeeMaker coffeeMaker;
    private Clock wallClock;

    private Cutlery cutlery;
    private final PizzaTheHut pizzaTheHut;

    public Kitchen() {
        this.pizzaTheHut = new PizzaTheHut();
        this.shower = new Shower(Shower.CONDITION_DEFECT);
        this.dishwasher = new Dishwasher();
        this.attemptsToShower = 0;
        this.coffeeMaker = new CoffeeMaker();
        this.wallClock = new Clock();

        this.cutlery = new Cutlery(20);
    }

    @Override
    public String getDescription() {
        return "the kitchen";
    }

    @Override
    public String getDetailedDescription() {
        return "The room is very unclean. It might be the kitchen. It reminds you of home. There is a colleague standing in the corner on top of some pizza boxes. You see " + Integer.toString(this.cutlery.totalAmtKnives) + " knives throughout the room. In a corner is a coffee maker that might still be working. On the left side of the room you see a dishwasher in an awesome condition. On the other side of the room you can see the ancient remains of a shower. It's definitely the worst shower you've ever seen and you refuse to inspect it more in details. The wallclock is one of the few remains in mint condition. Something might be alive over there...";
    }

    @Override
    public String handleCommand(String command) {
        switch (command.toLowerCase()) {
            case "clean kitchen":
                return "you are very funny";
            case "look at colleague":
                return pizzaTheHut.greet();
            case "do the knives fit into dishwasher":
                return dishwasher.couldLoadCutlery(this.cutlery) ? "they could fit" : "eeerp - overload!";
            case "turn on the shower":{
                if (attemptsToShower > 0) {
                    return "NO WAY! OTHERWISE I WILL VOMIT OUT MY SOUL...THIS ROTTEN STENCH...";
                }
                attemptsToShower += 1;
                return "It smells like something is rotten down in the sewer...";
            }
            case "time?":
                return "The wallclock says: " + this.wallClock.tellHhMm();
            case "drink coffee":
                return  "you feel great";
        }
        String message;
        if ((message = coffeeMaker.handle(command.toLowerCase())) != null) {
            return message;
        }

        return super.handleCommand(command.toLowerCase());
    }

    private void attemptToShower() {
        attemptsToShower += 1;
        this.shower.notifyAll();
        while (shower.isTurnedOn() && (dishwasher.getMaxNumberOfPlates() > dishwasher.getcleanKnivesLoaded())) {
            dishwasher.startCleaning();
        }
    }

    @Override
    public String getHelp() {
        List<String> availableCommands = coffeeMaker.listCommands();

         return "Help in the kitchen is useless, but just in case, you can: " + String.join(",", availableCommands) + "<br/>" + super.getHelp();
    }

    class Clock {
        private TimeService timeService;

        Clock() {
            this.timeService = new TimeService();
        }

        public String tellHhMm() {
            try {
                Date d = new Date(this.timeService.currentTime().longValue() * 1000);
                DateFormat df = new SimpleDateFormat("hh:mm");
                String ret = df.format(d);
                int h = d.getHours();
                if (h < 6) {
                    ret += " ... waaaaaay too early!";
                } else if (h < 12) {
                    ret += " ... yawn!";
                } else if (h < 18) {
                    ret += " ... lunch? food?";
                } else if (h < 24) {
                    ret += " ... pizza?";
                } else {
                    ret += " ... I see ghosts!";
                }

                return ret;
            } catch (Exception e) {
                return "dunno";
            }
        }
    }

	@Override
	public Location getLocation() {
        return Location.KITCHEN;
	}
}
