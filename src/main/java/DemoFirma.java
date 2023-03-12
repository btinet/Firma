
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.*;
import ui.FirmaDemoComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DemoFirma {

    // Attribute
    private final int window_width  = 1280;
    private final int window_height = 720;
    private boolean fullscreen = false;
    private JFrame frame;
    private FirmaDemoComponent demo;
    private GraphicsDevice device;

    private CardLayout cardLayout;


    // Constructor
    public DemoFirma() {
        demo = new FirmaDemoComponent();
        this.device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        setupWindow();
        showWindow();
    }

    // Methoden
    public void setupWindow() {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf());
            // FlatVuesionIJTheme.setup();
            FlatCyanLightIJTheme.setup();
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        frame = new JFrame();
        frame.add(demo);

        SwingUtilities.updateComponentTreeUI(frame);

        frame.setTitle("Demo Firma");
        frame.setResizable(false);

        frame.addWindowListener( new WindowAdapter() { public void windowClosing(WindowEvent evt) {
            System.exit(0);
        } });

        frame.addKeyListener( new KeyAdapter() { public void keyPressed(KeyEvent evt) {
            if (evt.getKeyCode()==KeyEvent.VK_ESCAPE) System.exit(0);
            else if (evt.getKeyCode()==KeyEvent.VK_F1) {
                destroyWindow();
                setupWindow();
                fullscreen = !fullscreen;
                showWindow();
            }
        } });
    }

    public void destroyWindow() {

        frame.setVisible(false);
        if (fullscreen) {
            device.setFullScreenWindow(null);
        }
        frame = null;
    }

    public void showWindow() {

        if (fullscreen) {
            int width  = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
            int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
            demo.setSize(width,height);
            frame.setSize(width,height);
            frame.setUndecorated(true);
            device.setFullScreenWindow(frame);
        } else {
            int width  = window_width;
            int height = window_height;
            demo.setSize(width,height);

            frame.pack();
            Insets insets = frame.getInsets();
            frame.setSize(width,height +insets.top);

        }
        frame.setCursor(Cursor.getDefaultCursor());
        frame.setVisible(true);
        frame.repaint();
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    // main class
    public static void main(String[] args) {
        DemoFirma demo = new DemoFirma();
    }

}
