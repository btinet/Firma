package entity;

import core.Country;

public class Forint extends Money {

    public Forint(int amount) {
        super(Country.HUNGARY,amount);
    }
}
