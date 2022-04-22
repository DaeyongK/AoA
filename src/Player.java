import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
public class Player extends Object {
    private ImageIcon walkOneRight, walkOneLeft, walkTwoRight, walkTwoLeft;
    private long aCount, dCount;
    private int health;
    private boolean one;
    Player(File spriteFile, int initX, int initY, int initWidth, int initHeight) throws IOException {
        super(spriteFile, initX, initY, initWidth, initHeight);
        health = 300;
    }
    public boolean getOne() {
        return one;
    }
    public void setOne(boolean o) {
        one = o;
    }
    public long getACount() {
        return aCount;
    }
    public long getDCount() {
        return dCount;
    }
    public void setACount(long ac) {
        aCount = ac;
    }
    public void setDCount(long dc) {
        dCount = dc;
    }
    public ImageIcon getWalkOneRight() {
        return walkOneRight;
    }
    public ImageIcon getWalkOneLeft() {
        return walkOneLeft;
    }
    public ImageIcon getWalkTwoRight() {
        return walkTwoRight;
    }
    public ImageIcon getWalkTwoLeft() {
        return walkTwoLeft;
    }
    public void setWalkOneRight(ImageIcon wor) {
        walkOneRight = wor;
    }
    public void setWalkOneLeft(ImageIcon wol) {
        walkOneLeft = wol;
    }
    public void setWalkTwoRight(ImageIcon wtr) {
        walkTwoRight = wtr;
    }
    public void setWalkTwoLeft(ImageIcon wtl) {
        walkTwoLeft = wtl;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int h) throws IOException {
        health = h;
        if(this instanceof Player1) {
            GameScreen.getHealth1().getSprite().setBounds(GameScreen.getHealth1().getX(), GameScreen.getHealth1().getY(), getHealth(), 30);
        } else {
            GameScreen.getHealth2().getSprite().setBounds(1350-getHealth(), GameScreen.getHealth2().getY(), getHealth(), 30);
        }
    }
}
