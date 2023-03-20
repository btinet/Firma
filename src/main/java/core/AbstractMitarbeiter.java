package core;

import entity.Money;

public abstract class AbstractMitarbeiter {

    // Attribute

    protected String name;
    protected String vorname;
    protected Money gehalt;

    protected EmployeeActionEnum action;

    // Constructor

    public AbstractMitarbeiter
            (
                    String vorname,
                    String name,
                    Money gehalt
            )
    {
        setName(name);
        setVorname(vorname);
        setGehalt(gehalt);
    }

    // Getter & Setter

    public String getFullName() {
        return String.format("%s %s",getVorname(),getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public Money getGehalt() {
        return gehalt;
    }

    public void setGehalt(Money gehalt) {
        this.gehalt = gehalt;
    }

    public void doAction() {
        this.action.doAction();
    }
}
