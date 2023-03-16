package entity;

import core.Country;
import core.Currency;

public abstract class Money extends Currency {

    protected Integer amount = 0;

    public Money(Country country) {
        super(country);
    }

    public String getCurrency() {
        return country.getCurrency(this.amount);
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public double getRate() {
        return this.country.getCurrencyRate();
    }

    public <T extends Money>  Money changeMoneyTo(Money newCurrency) {
        double result = this.getRate() * this.getAmount() / newCurrency.getRate();
        newCurrency.setAmount(Math.toIntExact(Math.round(result)));
        return newCurrency;
    }

    public String toString() {
        return getCurrency();
    }

}
