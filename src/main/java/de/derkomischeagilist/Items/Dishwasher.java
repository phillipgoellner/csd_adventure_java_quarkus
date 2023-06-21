package de.derkomischeagilist.Items;

import org.jboss.resteasy.util.DateUtil;

import java.util.Calendar;
import java.util.Date;

public class Dishwasher {

    String brand;
    String model;
    Date dateOfPurchase;
    Date dateWhenWarrantyEnds;

    Integer maxNumberOfPlates = 12;
    Integer cleanPlatesLoaded = 0;
    Integer dirtyPlatesLoaded = 0;

    Integer maxNumberOfCups = 12;
    Integer cleanCupsLoaded = 0;
    Integer dirtyCupsLoaded = 0;

    Integer maxNumberOfForks = 12;
    Integer cleanForksLoaded = 0;
    Integer dirtyForksLoaded = 0;

    Integer maxNumberOfKnives = 12;
    Integer cleanKnivesLoaded = 0;
    Integer dirtyKnivesLoaded = 0;

    Integer maxNumberOfSpoons = 12;
    Integer cleanSpoonsLoaded = 0;
    Integer dirtySpoonsLoaded = 0;

    Integer maxNumberOfTeaspoons = 12;
    Integer cleanTeaspoonsLoaded = 0;
    Integer dirtyTeaspoonsLoaded = 0;

    public Integer getMaxNumberOfPlates() {
        return maxNumberOfPlates;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getcleanKnivesLoaded() {
        return cleanKnivesLoaded;
    }

    public Integer loadDirtyKnives(Integer numberOfDirtyKnives) {
        dirtyKnivesLoaded += numberOfDirtyKnives;
        return dirtyKnivesLoaded;
    }

    public Boolean couldLoadCutlery(Cutlery cutlery) {
        return (this.dirtyKnivesLoaded += cutlery.totalAmtKnives) <= this.maxNumberOfKnives;
    }

    public Dishwasher() {
        this.brand = "ACME";
        this.model = "Superswoosh 9000XR";
        this.dateOfPurchase = new Date();

        // always add 180 days of warranty
        Calendar c = Calendar.getInstance();
        c.setTime(this.dateOfPurchase);
        c.add(Calendar.DATE, 180);
        this.dateWhenWarrantyEnds = c.getTime();
    }

    public void startCleaning() {
        this.cleanPlatesLoaded = this.dirtyPlatesLoaded;
        this.dirtyPlatesLoaded = 0;

        this.cleanCupsLoaded = this.dirtyCupsLoaded;
        this.dirtyCupsLoaded = 0;

        this.cleanForksLoaded = this.dirtyForksLoaded;
        this.dirtyForksLoaded = 0;

        this.cleanKnivesLoaded = this.dirtyKnivesLoaded;
        this.dirtyKnivesLoaded = 0;

        this.cleanSpoonsLoaded = this.dirtySpoonsLoaded;
        this.dirtySpoonsLoaded = 0;

        this.cleanTeaspoonsLoaded = this.dirtyTeaspoonsLoaded;
        this.dirtyTeaspoonsLoaded = 0;
    }
}
