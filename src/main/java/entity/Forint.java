package entity;

import core.Country;
import core.MoneyInterface;

public class Forint extends Money {

    public Forint() {
        super(Country.HUNGARY);
    }

    public Forint (int amount) {
        super(Country.HUNGARY);
        this.setAmount(amount);
    }

}
