package de.derkomischeagilist.Items;

public class CoffeeMaker {

    private Command[] commands;
    private boolean powerAvailable;
    private boolean coffeeInTheMachine;
    private boolean cupInTheMachine;
    private boolean waterInTheMachine;
    private String error = "";

    public CoffeeMaker() {
        commands = new Command[]{
            new AddBeans(this),
            new AddWater(this),
            new ConnectPower(this),
            new PutInCup(this),
            new MakeCoffee(this)
        };
    }

    public boolean makeCoffee() {
        error = "";
        if (powerAvailable) {
            if (coffeeInTheMachine) {
                if (cupInTheMachine) {
                    if (waterInTheMachine) {
                        return brew();
                    } else {
                        error = "There is no water in the machine";
                        return false;
                    }
                } else {
                    error = "There is no cup the machine";
                    return false;
                }
            } else {
                error = "There are no coffee beans in the machine";
                return false;
            }
        } else {
            error = "There is no power connected";
            return false;
        }
    }

    private boolean brew() {
        return true;
    }

    public String whatsWrong() {
        return error;
    }

    public void connectPower() {
        powerAvailable = true;
    }

    public void addCoffeeBeans() {
        coffeeInTheMachine = true;
    }

    public void putCupIn() {
        cupInTheMachine = true;
    }

    public void addWater() {
        waterInTheMachine = true;
    }

    public String handle(String incomingCommand) {
        for (Command command : commands) {
            String message = command.handle(incomingCommand);
            if (message != null) {
                return message;
            }
        }
        return null;
    }

    interface Command {
        String handle(String command);
    }

    private class AddBeans implements Command {
        private final CoffeeMaker coffeeMaker;

        public AddBeans(CoffeeMaker coffeeMaker) {
            this.coffeeMaker = coffeeMaker;
        }

        @Override
        public String handle(String command) {
            if (command.matches("add .*beans")) {
                coffeeMaker.addCoffeeBeans();
                return "Beans have been added to the coffee machine.";
            }
            return null;
        }
    }

    private class AddWater implements Command {
        private final CoffeeMaker coffeeMaker;

        public AddWater(CoffeeMaker coffeeMaker) {
            this.coffeeMaker = coffeeMaker;
        }

        @Override
        public String handle(String command) {
            if (command.matches("add .*water")) {
                coffeeMaker.addWater();
                return "Water has been added to the coffee machine.";
            }
            return null;
        }
    }

    private class ConnectPower implements Command {
        private final CoffeeMaker coffeeMaker;

        public ConnectPower(CoffeeMaker coffeeMaker) {
            this.coffeeMaker = coffeeMaker;
        }

        @Override
        public String handle(String command) {
            if (command.matches("connect power")) {
                coffeeMaker.connectPower();
                return "You turned on the coffee machine.";
            }
            return null;
        }
    }

    private class PutInCup implements Command {
        private final CoffeeMaker coffeeMaker;

        public PutInCup(CoffeeMaker coffeeMaker) {
            this.coffeeMaker = coffeeMaker;
        }

        @Override
        public String handle(String command) {
            if (command.matches("put in cup|put cup in")) {
                coffeeMaker.putCupIn();
                return "You put a cup in the coffee machine.";
            }
            return null;
        }
    }

    private class MakeCoffee implements Command {
        private final CoffeeMaker coffeeMaker;

        public MakeCoffee(CoffeeMaker coffeeMaker) {
            this.coffeeMaker = coffeeMaker;
        }

        @Override
        public String handle(String command) {
            if (command.matches("make coffee")) {
                coffeeMaker.putCupIn();
                return "You brewed a very nice looking cup of hot coffee.";
            }
            return null;
        }
    }
}

