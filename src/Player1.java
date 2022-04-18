import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
public class Player1 extends Player {
    Player1(File spriteFile, GameScreen gameScreen, int initX, int initY, int initWidth, int initHeight) throws IOException {
        super(spriteFile, gameScreen, initX, initY, initWidth, initHeight);
    }
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w' && getJump() > 0) {
            setYVelocity(getYVel()-25);
            subtractJump();
        } else if (e.getKeyChar() == 'a') {
            setXVelocity(-5);
        } else if (e.getKeyChar() == 'd') {
            setXVelocity(5);
        }
    }
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            if (getXVel() < 5) {
                setXVelocity(0);
            }
        } else if (e.getKeyChar() == 'd') {
            if (getXVel() > -5) {
                setXVelocity(0);
            }
        }
    }
}
