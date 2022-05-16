import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;public class PveWin extends JLayeredPane {
    CircularButton redo, exit;
    private JLabel backgroundImage, pts;
    PveWin(int score) throws IOException {
        super();
        setLayout(null);
        setBackground(new Color(255, 255, 255));
        pts = new JLabel(String.valueOf(score));
        pts.setFont(new Font("Serif", Font.BOLD, 65));
        pts.setForeground(Color.decode("#FF0000"));
        pts.setBounds(390, 110, 600, 150);
        redo = new CircularButton(270, 700, 150, Color.decode("#000000"), new Color(0.016f, 0.851f, 1f, .7f), "REDO");
        exit = new CircularButton(970, 700, 150, Color.decode("#000000"), new Color(0.016f, 0.851f, 1f, .7f), "EXIT");
        if(score==0) {
            backgroundImage = new Object(new File("Images/balloonsScreenHowDid.png"), 0, 0, 1400, 950).getSprite();
        } else if(score==1) {
            backgroundImage = new Object(new File("Images/balloonsScreenBetterLuck.png"), 0, 0, 1400, 950).getSprite();
        } else if(score < 10) {
            backgroundImage = new Object(new File("Images/balloonsScreenNotBad.png"), 0, 0, 1400, 950).getSprite();
        } else if(score < 20) {
            backgroundImage = new Object(new File("Images/balloonsScreenWow.png"), 0, 0, 1400, 950).getSprite();
        } else {
            backgroundImage = new Object(new File("Images/balloonsScreenNANI.png"), 0, 0, 1400, 950).getSprite();
        }
        add(pts);
        add(redo);
        add(exit);
        add(backgroundImage);
        moveToBack(backgroundImage);
        repaint();
    }
}