import javax.swing.*;
import java.io.File;
import java.io.IOException;
public class Player extends Object {
    private ImageIcon walkOneRight, walkOneLeft, walkTwoRight, walkTwoLeft;
    private long aCount, dCount;
    private boolean one;
    Player(File spriteFile, int initX, int initY, int initWidth, int initHeight) throws IOException {
        super(spriteFile, initX, initY, initWidth, initHeight);
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
}
