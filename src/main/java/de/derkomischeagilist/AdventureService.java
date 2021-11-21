package de.derkomischeagilist;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AdventureService {
    private final Adventure adventure;

    public AdventureService() {
        adventure = new Adventure();
    }

    public Adventure getAdventure() {
        return adventure;
    }

}
