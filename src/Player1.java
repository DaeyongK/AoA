import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
public class Player1 extends Player {
    Player1(File spriteFile, int initX, int initY, int initWidth, int initHeight) throws IOException {
        super(spriteFile, initX, initY, initWidth, initHeight);
        setWalkOneRight(new ImageIcon(resizeImage(ImageIO.read(new File("Images/Kaguya/Kaguya_Walking_One.png")), initWidth, initHeight)));
        setWalkTwoRight(new ImageIcon(resizeImage(ImageIO.read(new File("Images/Kaguya/Kaguya_Walking_Two.png")), initWidth, initHeight)));
        setWalkOneLeft(new ImageIcon(resizeImage(ImageIO.read(new File("Images/Kaguya/Kaguya_Reverse/Kaguya_Reverse_Walking_One.png")), initWidth, initHeight)));
        setWalkTwoLeft(new ImageIcon(resizeImage(ImageIO.read(new File("Images/Kaguya/Kaguya_Reverse/Kaguya_Reverse_Walking_Two.png")), initWidth, initHeight)));
        changeSprite(getWalkOneRight());
        setOne(true);
    }
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) throws IOException {
        if (e.getKeyChar() == 'w' && getJump() > 0) {
            setYVelocity(getYVel()-25);
            subtractJump();
        } else if (e.getKeyChar() == 'a') {
            changeSprite(getWalkOneLeft());
            setXVelocity(-5);
        } else if (e.getKeyChar() == 'd') {
            changeSprite(getWalkOneRight());
            setXVelocity(5);
        } else if (e.getKeyChar() == 'q') {
            setHealth(getHealth()-10);
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
