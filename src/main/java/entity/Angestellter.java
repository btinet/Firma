package entity;

import core.AbstractMitarbeiter;

public class Angestellter extends AbstractMitarbeiter {

    // Attribute

    protected double provision = 0;

    // Constructor

    public Angestellter
            (
                    String vorname,
                    String name,
                    Money gehalt
            )
    {
        super(vorname, name, gehalt);
    }

    // Getter & Setter

    public double getProvision() {
        return provision;
    }

    public void setProvision(double provision) {
        this.provision = provision;
    }
}
