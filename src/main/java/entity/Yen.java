package entity;

import core.Country;

public class Yen extends Money {

    public Yen() {
        super(Country.JAPAN);
    }

    public Yen (int amount) {
        super(Country.JAPAN);
        this.setAmount(amount);
    }
}
