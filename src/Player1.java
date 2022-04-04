import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
public class Player1 extends Player {
    Player1(File spriteFile, GameScreen gameScreen, int initX, int initY, int initWidth, int initHeight) throws IOException {
        super(spriteFile, gameScreen, initX, initY, initWidth, initHeight);
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            setYVelocity(-5);
        } else if (e.getKeyChar() == 'a') {
            setXVelocity(-5);
        } else if (e.getKeyChar() == 's') {
            setYVelocity(5);
        } else if (e.getKeyChar() == 'd') {
            setXVelocity(5);
        }
    }
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            if (getYVel() < 5) {
                setYVelocity(0);
            }
        } else if (e.getKeyChar() == 'a') {
            if (getXVel() < 5) {
                setXVelocity(0);
            }
        } else if (e.getKeyChar() == 's') {
            if (getYVel() > -5) {
                setYVelocity(0);
            }
        } else if (e.getKeyChar() == 'd') {
            if (getXVel() > -5) {
                setXVelocity(0);
            }
        }
    }
}
