package entity;

import core.Country;
import core.Currency;

public abstract class Money extends Currency {

    protected Integer amount;

    public Money(Country country, int amount) {
        super(country);
        this.amount = amount;
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

    public Integer changeMoneyTo(Money newCurrency) {
        double result = this.getRate() * this.getAmount() / newCurrency.getRate();
        return Math.toIntExact(Math.round(result));
    }

}
