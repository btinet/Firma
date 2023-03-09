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

    // Methods

    public void setGehalt() {
        super.setGehalt(getStunden()*getStundenlohn());
    }

    public void updateGehalt(double stunden) {
        super.setGehalt(stunden*getStundenlohn()+getGehalt());
    }

    public void addStunden(double stunden) {
        this.stunden += stunden;
        updateGehalt(stunden);
    }


    // Getter & Setter

    public double getStunden() {
        return stunden;
    }

    public void setStunden(double stunden) {
        if(getGehalt() != 0)
        {
            System.out.printf("Um das Gehalt über %s von %s zu überschreiben, bitte zweiten Parameter auf 'true' setzen!%n",getGehalt(),getFullName());
        } else {
            this.stunden = stunden;
            setGehalt();
        }
    }

    public void setStunden(double stunden,boolean forceOverwrite) {
        if(getGehalt() != 0 && !forceOverwrite) {
            System.err.printf("Um das Gehalt über %s von %s zu überschreiben, bitte zweiten Parameter auf 'true' setzen!",getGehalt(),getFullName());
        } else {
            this.stunden = stunden;
            setGehalt();
        }
    }

    public double getStundenlohn() {
        return stundenlohn;
    }

    public void setStundenlohn(double stundenlohn) {
        this.stundenlohn = stundenlohn;
    }
}
