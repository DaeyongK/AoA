import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
public class Player2 extends Player {
    Player2(File spriteFile, int initX, int initY, int initWidth, int initHeight) throws IOException {
        super(spriteFile, initX, initY, initWidth, initHeight);
        setWalkOneRight(getIcon(new File("Images/Kaguya/Kaguya_Walking_One.png")));
        setWalkTwoRight(getIcon(new File("Images/Kaguya/Kaguya_Walking_Two.png")));
        setWalkOneLeft(getIcon(new File("Images/Kaguya/Kaguya_Reverse/Kaguya_Reverse_Walking_One.png")));
        setWalkTwoLeft(getIcon(new File("Images/Kaguya/Kaguya_Reverse/Kaguya_Reverse_Walking_Two.png")));
        setF1(getIcon(new File("Images/Kaguya/Kaguya_LoveLetter_One.png")));
        setF2(getIcon(new File("Images/Kaguya/Kaguya_LoveLetter_Two.png")));
//        setF3(getIcon(new File("Images/Kaguya/Kaguya_LoveLetter_Three.png")));
//        setF4(getIcon(new File("Images/Kaguya/Kaguya_LoveLetter_Four.png")));
        setF1R(getIcon(new File("Images/Kaguya/Kaguya_Reverse/Kaguya_Reverse_LoveLetter_One.png")));
        setF2R(getIcon(new File("Images/Kaguya/Kaguya_Reverse/Kaguya_Reverse_LoveLetter_Two.png")));
//        setF3R(getIcon(new File("Images/Kaguya/Kaguya_Reverse/Kaguya_Reverse_LoveLetter_Three.png")));
//        setF4R(getIcon(new File("Images/Kaguya/Kaguya_Reverse/Kaguya_Reverse_LoveLetter_Four.png")));
        setLeftFacing(true);
        setOne(true);
    }
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) throws IOException {
        if (e.getKeyCode() == KeyEvent.VK_UP && getJump() > 0) {
            setYVelocity(getYVel()-25);
            subtractJump();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            setLeftFacing(true);
            setXVelocity(-5);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            setLeftFacing(false);
            setXVelocity(5);
        } else if (e.getKeyChar() == 'i') {
            setLoveLetter(true);
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