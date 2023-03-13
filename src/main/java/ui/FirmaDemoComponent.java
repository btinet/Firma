package ui;

import core.AbstractMitarbeiter;
import core.Currency;
import entity.Angestellter;
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

        Angestellter olafOffice = new Angestellter("Olaf","Office",3750);
        employeeObjects.add(olafOffice);


        JTextField textField = new JTextField(olafOffice.getFullName() + " ist ein super Angestellter");
        textFieldObjects.add(textField);
        JButton button = new JButton("Klick mich");
        JButton button2 = new JButton("Klick mich");
        button.addActionListener(this::clickButton);
        button2.addActionListener(this::clickButton);
        this.add(button);
        this.add(button2);
        this.add(textField);

        Euro euro = new Euro(59900);
        Forint forint = new Forint(59900);

        System.out.printf("In Euro sind es %s%n",euro.getMoney());
        System.out.printf("In Forint sind es aber %s%n",forint.getMoney());

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
