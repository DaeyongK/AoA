import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    Player1 p1;
    MyKeyListener(Player1 player) {
        p1 = player;
    }
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {
        p1.keyPressed(e);
    }
    public void keyReleased(KeyEvent e) {
        p1.keyReleased(e);
    }
}