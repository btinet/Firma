package ui;

import core.AbstractMitarbeiter;
import entity.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ListIterator;

public class FirmaDemoComponent extends JPanel implements ActionListener {

    // Attribute
    public static int width, height;
    private float scale = 1.0f;
    public static final int table_size = 760;

    protected ArrayList<AbstractMitarbeiter> employeeObjects = new ArrayList<>();
    protected ArrayList<JTextField> textFieldObjects = new ArrayList<>();

    // Constructor

    public FirmaDemoComponent() {

        GridBagLayout experimentLayout = new GridBagLayout();



        setLayout(experimentLayout);

        System.out.println("Komponente geladen.");

        // instanziiere Mitarbeiter-Objekte
        Angestellter olafOffice = new Angestellter("Olaf","Office",new Euro(375000));
        Arbeiter bauBernd = new Arbeiter("Bernd","Bau",new Euro(125000),new Euro(500));
        Arbeiter travelTao = new Arbeiter("Tao","Travel",new Yen(10000),new Yen(1200));
        travelTao.addStunden(10);

        // füge Mitarbeiter der Objektliste hinzu (wichtig später für die UI)
        employeeObjects.add(olafOffice);
        employeeObjects.add(bauBernd);
        employeeObjects.add(travelTao);

        // Beginn: UI-Swing-Elemente


        /*
            JButton button = new JButton("Klick mich");
            JButton button2 = new JButton("Klick mich");
            button.addActionListener(this::clickButton);
            button2.addActionListener(this::clickButton);
            this.add(button);
            this.add(button2);
         */


        // Ende: UI-Swing-Elemente


        // Testweises Erzeugen von Währungsobjekten sowie deren Ausgabe auf der Konsole
        Euro euro = new Euro();
        euro.setAmount(59900);
        Forint forint = new Forint();

        System.out.printf("%s sind umgerechnet %s.%n",euro,euro.changeMoneyTo(forint));

        // Konsolenausgabe: Arbeiter mit Grundgehalt. Einmal ohne Stundenlohn, einmal + Lohn für 10 Stunden
        // Arbeit zu je 5,00 EUR.
        System.out.printf(
                "%s erhält aktuell %s, da er %s Stunden gearbeitet hat%n",
                bauBernd.getFullName(),bauBernd.getGehalt(),bauBernd.getStunden()
        );

        bauBernd.addStunden(10);

        System.out.printf(
                "%s erhält aktuell %s, da er %s Stunden gearbeitet hat%n",
                bauBernd.getFullName(),bauBernd.getGehalt(),bauBernd.getStunden()
        );

        // Ausgabe des Gehaltes mit Umrechnung in andere Währung.
        System.out.printf(
                "%s erhält aktuell %s, da er %s Stunden gearbeitet hat%n",
                travelTao.getFullName(),travelTao.getGehalt().changeMoneyTo(new Euro()),travelTao.getStunden()
        );

        addElementsToCanvas();
    }

    // Methoden

    public void addElementsToCanvas () {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = 1;
        gbc.ipadx = 200;
        gbc.weightx = 0;
        gbc.weighty = 0;

        this.add(new JLabel("Vollständiger Name"),gbc);
        this.add(new JLabel("Gehalt gesamt"),gbc);
        this.add(new JLabel("Stundenlohn"),gbc);
        this.add(new JLabel("Arbeitsstunden"),gbc);

        int i = 1;

        for (AbstractMitarbeiter employeeObject : this.employeeObjects) {

            gbc.gridy = i;

            switch (employeeObject.getClass().getSimpleName()) {

                case "Arbeiter":
                    Arbeiter arbeiter = (Arbeiter) employeeObject;
                    this.add(new JLabel(arbeiter.getFullName()), gbc);
                    this.add(new JLabel(arbeiter.getGehalt().changeMoneyTo(new Euro()).getCurrency()), gbc);
                    this.add(new JLabel(arbeiter.getStundenlohn().changeMoneyTo(new Euro()).getCurrency()), gbc);
                    this.add(new JLabel(String.valueOf(arbeiter.getStunden())), gbc);
                    break;

                case "Angestellter":
                    Angestellter angestellter = (Angestellter) employeeObject;
                    this.add(new JLabel(angestellter.getFullName()), gbc);
                    this.add(new JLabel(angestellter.getGehalt().getCurrency()), gbc);
                    break;

                default:
                    System.out.println("Erbt von AbstractMitarbeiter, wurde jedoch noch nicht implementiert.");

            }
            i++;
        }
    }

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
