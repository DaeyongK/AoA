import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
public class StartScreen extends JLayeredPane {
    CircularButton pvp, pve, exit;
    private JLabel backgroundImage;
    StartScreen() throws IOException {
        super();
        setLayout(null);
        setBackground(new Color(255, 255, 255));
        pvp = new CircularButton(270, 700, 150, Color.decode("#000000"), new Color(0.016f, 0.851f, 1f, .7f), "PVP");
        pve = new CircularButton(620, 700, 150, Color.decode("#000000"), new Color(0.016f, 0.851f, 1f, .7f), "PVE");
        exit = new CircularButton(970, 700, 150, Color.decode("#000000"), new Color(0.016f, 0.851f, 1f, .7f), "EXIT");
        backgroundImage = new Object(new File("Images/IntroScreen.png"), 0, 0, 1400, 950).getSprite();
        add(pvp);
        add(pve);
        add(exit);
        add(backgroundImage);
        moveToBack(backgroundImage);
        repaint();
    }
}
