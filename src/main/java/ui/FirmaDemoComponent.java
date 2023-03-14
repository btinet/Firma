package ui;

import core.AbstractMitarbeiter;
import core.Currency;
import entity.Angestellter;
import entity.Arbeiter;
import entity.Euro;
import entity.Forint;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FirmaDemoComponent extends JPanel implements ActionListener {

    // Attribute
    public static int width, height;
    private float scale = 1.0f;
    public static final int table_size = 760;

    protected ArrayList<AbstractMitarbeiter> employeeObjects = new ArrayList<>();
    protected ArrayList<JTextField> textFieldObjects = new ArrayList<>();

    // Constructor

    public FirmaDemoComponent() {

        System.out.println("Komponente geladen.");

        // instanziiere Mitarbeiter-Objekte
        Angestellter olafOffice = new Angestellter("Olaf","Office",new Euro(375000));
        Arbeiter bauBernd = new Arbeiter("Bernd","Bau",new Euro(125000),new Euro(500));

        // füge Mitarbeiter der Objektliste hinzu (wichtig später für die UI)
        employeeObjects.add(olafOffice);
        employeeObjects.add(bauBernd);

        // Beginn: UI-Swing-Elemente
        JTextField textField = new JTextField(olafOffice.getFullName() + " ist ein super Angestellter");
        textFieldObjects.add(textField);
        JButton button = new JButton("Klick mich");
        JButton button2 = new JButton("Klick mich");
        button.addActionListener(this::clickButton);
        button2.addActionListener(this::clickButton);
        this.add(button);
        this.add(button2);
        this.add(textField);
        // Ende: UI-Swing-Elemente


        // Testweises Erzeugen von Währungsobjekten sowie deren Ausgabe auf der Konsole
        Euro euro = new Euro(59900);
        Forint forint = new Forint(59900);
        System.out.printf("In Euro sind es %s%n",euro.getCurrency());
        System.out.printf("In Forint sind es aber %s%n",forint.getCurrency());

        forint.setAmount(euro.changeMoneyTo(forint));

        System.out.printf("%s sind umgerechnet %s.%n",euro.getCurrency(),forint.getCurrency());

        // Konsolenausgabe: Arbeiter mit Grundgehalt. Einmal ohne Stundenlohn, einmal + Lohn für 10 Stunden Arbet zu je 5,00 EUR.
        System.out.printf("%s erhält aktuell %s, da er %s Stunden gearbeitet hat%n",bauBernd.getFullName(),bauBernd.getGehalt().getCurrency(),bauBernd.getStunden());
        bauBernd.addStunden(10);
        System.out.printf("%s erhält aktuell %s, da er %s Stunden gearbeitet hat%n",bauBernd.getFullName(),bauBernd.getGehalt().getCurrency(),bauBernd.getStunden());
    }

    // Methoden
    public void setSize(int w, int h) {
        super.setSize(w,h);
        width = w;
        height = h;
        scale  = height/(float)FirmaDemoComponent.table_size;
    }

    public void clickButton(ActionEvent e) {
        System.out.println("Knopf wurde gedrückt.");
        this.employeeObjects.get(0).setName("X");
        this.textFieldObjects.get(0).setText(this.employeeObjects.get(0).getFullName());
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
