package entity;

import core.Country;
import core.Currency;

public abstract class Money extends Currency {

    protected Integer amount;

    public Money(Country country, int amount) {
        super(country);
        this.amount = amount;
    }

    public String getMoney() {
        return country.getMoney(this.amount);
    }

}
