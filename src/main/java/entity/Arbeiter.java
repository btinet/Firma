package entity;

import core.AbstractMitarbeiter;
import core.EmployeeActionEnum;

public class Arbeiter extends AbstractMitarbeiter {

    // Attribute

    protected double stunden = 0;
    protected Money stundenlohn;

    // Constructor

    public Arbeiter
            (
                    String vorname,
                    String name,
                    Money gehalt,
                    Money stundenlohn
            )
    {
        super(vorname, name, gehalt);
        this.stundenlohn = stundenlohn;
        this.action = EmployeeActionEnum.arbeiter;
    }

    // Methods

    public void setGehalt() {
        this.getGehalt().setAmount((int) (getStunden()*getStundenlohn().getAmount()));
    }

    public void updateGehalt(int stunden) {
        this.getGehalt().setAmount(stunden*getStundenlohn().getAmount()+getGehalt().getAmount());
    }

    public void addStunden(int stunden) {
        this.stunden += stunden;
        updateGehalt(stunden);
    }


    // Getter & Setter

    public double getStunden() {
        return stunden;
    }

    public void setStunden(double stunden) {
        if(getGehalt().getAmount() != 0)
        {
            System.out.printf("Um das Gehalt über %s von %s zu überschreiben, bitte zweiten Parameter auf 'true' setzen!%n",getGehalt(),getFullName());
        } else {
            this.stunden = stunden;
            setGehalt();
        }
    }

    public void setStunden(double stunden,boolean forceOverwrite) {
        if(getGehalt().getAmount() != 0 && !forceOverwrite) {
            System.err.printf("Um das Gehalt über %s von %s zu überschreiben, bitte zweiten Parameter auf 'true' setzen!",getGehalt(),getFullName());
        } else {
            this.stunden = stunden;
            setGehalt();
        }
    }

    public Money getStundenlohn() {
        return stundenlohn;
    }

    public void setStundenlohn(Integer stundenlohn) {
        this.stundenlohn.setAmount(stundenlohn);
    }
}
