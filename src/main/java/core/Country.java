package core;

import java.text.DecimalFormat;

public enum Country {

    GERMANY ("Euro","EUR",true,1.19),
    HUNGARY ("Forint","HUF", false, 0.89),
    AUSTRIA ("Euro","EUR",true,0.9),
    USA ("Dollar","USD",true,1),
    JAPAN("Yen","YEN",false,0.5),
    BRITAIN ("Pound Sterling","GPB",true,1.4);

    private final String name;
    private final String abbr;
    private final boolean isFloat;

    private final double currencyRate;

    Country(String currencyName, String currencyAbbreviation, boolean isFloat, double currencyRate) {
        this.name = currencyName;
        this.abbr = currencyAbbreviation;
        this.isFloat = isFloat;
        this.currencyRate = currencyRate;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getName() {
        return name;
    }

    public Boolean isFloat() {
        return isFloat;
    }

    public double getCurrencyRate() {
        return currencyRate;
    }

    private String getAmountAsString(Integer amount) {
        Float money = amount.floatValue() / 100;
        return new DecimalFormat("#0.00").format(money);
    }

    public String getCurrency(Integer amount) {
        if(isFloat) {
            return String.format("%s %s",getAmountAsString(amount),abbr);
        } else {
            return String.format("%s %s",amount,abbr);
        }
    }

}
