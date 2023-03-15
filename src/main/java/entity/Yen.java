package entity;

import core.Country;

public class Yen extends Money {

    public Yen(int amount) {
        super(Country.JAPAN,amount);
    }
}
