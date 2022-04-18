import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
public class Player2 extends Player {
    Player2(File spriteFile, GameScreen gameScreen, int initX, int initY, int initWidth, int initHeight) throws IOException {
        super(spriteFile, gameScreen, initX, initY, initWidth, initHeight);
    }
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP && getJump() > 0) {
            setYVelocity(getYVel()-25);
            subtractJump();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            setXVelocity(-5);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            setXVelocity(5);
        }
    }
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (getXVel() < 5) {
                setXVelocity(0);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (getXVel() > -5) {
                setXVelocity(0);
            }
        }
    }
}