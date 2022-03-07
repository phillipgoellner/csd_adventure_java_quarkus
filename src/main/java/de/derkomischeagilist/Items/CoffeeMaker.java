package de.derkomischeagilist.Items;

public class CoffeeMaker {

    private boolean powerAvailable;
    private boolean coffeeInTheMachine;
    private boolean cupInTheMachine;
    private boolean waterInTheMachine;
    private String error = "";

    public boolean makeCoffee() {
        error = "";
        if (powerAvailable) {
            if(coffeeInTheMachine) {
                if (cupInTheMachine) {
                    if(waterInTheMachine) {
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
}
