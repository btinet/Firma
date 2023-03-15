package entity;

import core.Country;

public class Euro extends Money {


    public Euro () {
        super(Country.GERMANY,0);
    }

    public Euro(int amount) {
        super(Country.GERMANY,amount);
    }
}
