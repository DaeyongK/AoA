import javax.swing.*;
import java.awt.*;

public class StartScreen extends JPanel {
    CircularButton pvp, pve, exit;
    StartScreen() {
        super();
        setLayout(null);
        setBackground(new Color(255,255,255));
        pvp = new CircularButton(300, 500, 150, Color.decode("#000000"), new Color(0.016f, 0.851f, 1f, .7f ), "PVP");
        pve = new CircularButton(600, 500, 150, Color.decode("#000000"), new Color(0.016f, 0.851f, 1f, .7f ), "PVE");
        exit = new CircularButton(900, 500, 150, Color.decode("#000000"), new Color(0.016f, 0.851f, 1f, .7f ), "EXIT");
//        pvp.setFocusable(false);
//        pve.setFocusable(false);
//        exit.setFocusable(false);
        add(pvp);
        add(pve);
        add(exit);

    }
}
