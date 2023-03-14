package core;

public abstract class Currency {

    protected Country country;

    public Currency(Country country) {
        this.country = country;
    }

    public String getLabel() {
        return this.country.getName();
    }

    public String getAbbreviation() {
        return this.country.getAbbr();
    }

    public Boolean isFloat() {
        return this.country.isFloat();
    }



}
