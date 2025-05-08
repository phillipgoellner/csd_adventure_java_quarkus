package de.derkomischeagilist;

import java.util.ArrayList;

public class Inventory {
  
    private ArrayList<String> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public boolean hasItem(String item) {
        return items.contains(item);
    }

    public boolean addItem(String item) {
        if(!hasItem(item)) {
        return items.add(item);
        }
        
        return false;
    }

    public boolean removeItem(String item) {
        return items.remove(item);
    }

    public void clear() {
        items.clear();
    }

    @Override
    public String toString() {
        if (items.size() == 0) {
            return "Empty";
        }

        return String.join(", ", items);
    }
}
