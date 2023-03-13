package core;

import java.text.DecimalFormat;

public enum Country {

    GERMANY ("Euro","EUR",true),
    HUNGARY ("Forint","HUF", false),
    AUSTRIA ("Euro","EUR",true),
    BRITAIN ("Pound Sterling","GPB",true);

    private final String name;
    private final String abbr;
    private final boolean isFloat;

    Country(String currencyName, String currencyAbbreviation, boolean isFloat) {
        this.name = currencyName;
        this.abbr = currencyAbbreviation;
        this.isFloat = isFloat;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getName() {
        return name;
    }

    public String getAmountAsString(Integer amount) {
        Float money = amount.floatValue() / 100;
        return new DecimalFormat("##.00").format(money);
    }

    public String getMoney(Integer amount) {
        if(isFloat) {
            return String.format("%s %s",getAmountAsString(amount),abbr);
        } else {
            return String.format("%s %s",amount,abbr);
        }
    }

}
