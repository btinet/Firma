package entity;

import core.Country;

public class Euro extends Money {

    public Euro(int amount) {
        super(Country.GERMANY,amount);
    }
}
