import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class MyKeyListener implements KeyListener {
    Player1 p1;
    Player2 p2;
    MyKeyListener(Player1 pl1, Player2 pl2) {
        p1 = pl1;
        p2 = pl2;
    }
    public void keyTyped(KeyEvent e) {
        p1.keyTyped(e);
        p2.keyTyped(e);
    }
    public void keyPressed(KeyEvent e) {
        try {
            p1.keyPressed(e);
        } catch (IOException ex) {}
        try {
            p2.keyPressed(e);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void keyReleased(KeyEvent e) {
        p1.keyReleased(e);
        p2.keyReleased(e);
    }
}