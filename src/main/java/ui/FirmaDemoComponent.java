package ui;

import entity.Angestellter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirmaDemoComponent extends JPanel implements ActionListener {

    // Attribute
    public static int width, height;
    private float scale = 1.0f;
    public static final int table_size = 760;

    // Constructor

    public FirmaDemoComponent() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        System.out.println("Komponente geladen.");

        Angestellter olafOffice = new Angestellter("Olaf","Office",3750);

        JTextField textField = new JTextField(olafOffice.getFullName());
        JButton button = new JButton("KLick mich");
        button.addActionListener(this::clickButton);
        this.add(button);
        this.add(textField);
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
