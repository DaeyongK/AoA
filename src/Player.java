import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
public class Player extends Object {
    private ImageIcon walkOneRight, walkOneLeft, walkTwoRight, walkTwoLeft, f1, f2, f3, f1r, f2r, f3r;
    private long aCount, dCount, startTime;
    private int health, aniFrameOrder = 0;
    private boolean one, leftFacing, loveLetter;
    Player(File spriteFile, int initX, int initY, int initWidth, int initHeight) throws IOException {
        super(spriteFile, initX, initY, initWidth, initHeight);
        health = 300;
    }
    public void setStartTime() {
        startTime = System.currentTimeMillis();
    }
    public long getStartTime() {
        return startTime;
    }
    public void setAniFrameOrder(int afo) {
        aniFrameOrder = afo;
    }
    public int getAniFrameOrder() {
        return aniFrameOrder;
    }
    public void setLoveLetter(boolean ll) {loveLetter = ll;}
    public boolean getLoveLetter() {return loveLetter;}
    public boolean getLeftFacing() {return leftFacing;}
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
    public ImageIcon getF1() {return f1;}
    public ImageIcon getF2() {return f2;}
    public ImageIcon getF3() {return f3;}
//    public ImageIcon getF4() {return f4;}
    public ImageIcon getF1R() {return f1r;}
    public ImageIcon getF2R() {return f2r;}
    public ImageIcon getF3R() {return f3r;}
//    public ImageIcon getF4R() {return f4r;}
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
    public void setLeftFacing(boolean lf) {leftFacing = lf;}
    public void setF1(ImageIcon fAttack) {f1 = fAttack;}
    public void setF2(ImageIcon fAttack) {f2 = fAttack;}
    public void setF3(ImageIcon fAttack) {f3 = fAttack;}
//    public void setF4(ImageIcon fAttack) {f4 = fAttack;}
    public void setF1R(ImageIcon fAttack) {f1r = fAttack;}
    public void setF2R(ImageIcon fAttack) {f2r = fAttack;}
    public void setF3R(ImageIcon fAttack) {f3r = fAttack;}
//    public void setF4R(ImageIcon fAttack) {f4r = fAttack;}
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
    public Projectile loveLetter() throws IOException {
        Projectile letter = null;
        if(getAniFrameOrder() == 0) {
            setStartTime();
            if(getLeftFacing()) {
                changeSprite(getF1R());
            } else {
                changeSprite(getF1());
            }
            setAniFrameOrder(getAniFrameOrder()+1);
        } else if(getAniFrameOrder() == 1 && (System.currentTimeMillis() - getStartTime()) > 75) {
            if(getLeftFacing()) {
                changeSprite(getF2R());
                letter = new Projectile(new File("Images/AccessoryFolder/Reverse_NewHeartLetterOne.png"), getX()-100, getY()+30, 85, 15, -15, 0, 10);
            } else {
                changeSprite(getF2());
                letter = new Projectile(new File("Images/AccessoryFolder/NewHeartLetterOne.png"), getX()+50, getY()+30, 85, 15, 15, 0, 10);
            }
            setAniFrameOrder(getAniFrameOrder()+1);
        } else if(getAniFrameOrder() == 2 && (System.currentTimeMillis() - getStartTime()) > 150) {
            letter = null;
            if (getLeftFacing()) {
                changeSprite(getWalkOneLeft());
            } else {
                changeSprite(getWalkOneRight());
            }
            setLoveLetter(false);
            setAniFrameOrder(0);
        }
        return letter;
    }
}
