package de.derkomischeagilist.Items;

public class Shower {

    private String condition;
    public static final String CONDITION_NEW = "new";
    public static final String CONDITION_USED = "used, but okayish";
    public static final String CONDITION_DEFECT = "defect";

    public Shower(String condition) {
        this.condition = condition;
    }

    public Shower() {
        this.condition = CONDITION_NEW;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public boolean isTurnedOn() {
        return turnedOn;
    }

    public void isTurnedOff() {
        return !this.turnedOn;
    }
}
