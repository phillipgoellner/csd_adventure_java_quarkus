package de.derkomischeagilist;

public enum Location {
    LOO("Loo"),
    WASHROOM("Washroom"),
    HALLWAY("Hallway"),
    TEAM_OFFICE("Team Office"),
    KITCHEN("Kitchen");

    private String name;

    Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
