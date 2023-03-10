package ui;

import javax.swing.*;

public class FirmaDemoComponent extends JComponent {

    // Attribute
    public static int width, height;
    private float scale = 1.0f;
    public static final int table_size = 760;

    // Methoden
    public void setSize(int w, int h) {
        super.setSize(w,h);
        width = w;
        height = h;
        scale  = height/(float)FirmaDemoComponent.table_size;
    }

}
