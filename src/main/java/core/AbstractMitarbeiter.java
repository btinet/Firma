package core;

public abstract class AbstractMitarbeiter {

    // Attribute

    protected String name;
    protected String vorname;
    protected double gehalt;

    // Constructor

    public AbstractMitarbeiter
            (
                    String vorname,
                    String name,
                    double gehalt
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

    public double getGehalt() {
        return gehalt;
    }

    public void setGehalt(double gehalt) {
        this.gehalt = gehalt;
    }
}
