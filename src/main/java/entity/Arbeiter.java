package entity;

import core.AbstractMitarbeiter;

public class Arbeiter extends AbstractMitarbeiter {

    // Attribute

    protected double stunden = 0;
    protected double stundenlohn = 0;

    // Constructor

    public Arbeiter
            (
                    String vorname,
                    String name,
                    double gehalt
            )
    {
        super(vorname, name, gehalt);
    }

    // Methoden

    public double getLohn() {
        if(getStunden() != 0) {
            return getStundenlohn() * getStunden();
        } else {
            System.out.println(getVorname() + " hat noch nicht gearbeitet!");
            return 0;
        }

    }

    // Getter & Setter

    public double getStunden() {
        return stunden;
    }

    public void setStunden(double stunden) {
        this.stunden = stunden;
    }

    public double getStundenlohn() {
        return stundenlohn;
    }

    public void setStundenlohn(double stundenlohn) {
        this.stundenlohn = stundenlohn;
    }
}
