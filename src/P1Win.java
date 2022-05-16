import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
public class P1Win extends JLayeredPane {
    CircularButton redo, exit;
    private JLabel backgroundImage;
    P1Win() throws IOException {
        super();
        setLayout(null);
        setBackground(new Color(255, 255, 255));
        redo = new CircularButton(590, 390, 150, Color.decode("#000000"),
        new Color(0.016f, 0.851f, 1f, .7f), "REDO");
        exit = new CircularButton(590, 650, 150, Color.decode("#000000"),
        new Color(0.016f, 0.851f, 1f, .7f), "EXIT");
        backgroundImage = new Object(new File("Images/PlayerOneScreen.png"),
        0, 0, 1400, 950).getSprite();
        add(redo);
        add(exit);
        add(backgroundImage);
        moveToBack(backgroundImage);
        repaint();
    }
}