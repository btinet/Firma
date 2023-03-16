package entity;

import core.Country;

public class Euro extends Money {


    public Euro () {
        super(Country.GERMANY);
    }

    public Euro (int amount) {
        super(Country.GERMANY);
        this.setAmount(amount);
    }

}
