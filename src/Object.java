import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Object {
    private JLabel sprite;
    private int xPos, yPos, xVel, yVel, width, height;
    private int jump = 1;
    Object(File spriteFile, GameScreen gameScreen, int initX, int initY, int initWidth, int initHeight, double g) throws IOException {
        xPos = initX;
        yPos = initY;
        width = initWidth;
        height = initHeight;
        sprite = new JLabel(new ImageIcon(resizeImage(ImageIO.read(spriteFile), initWidth, initHeight)));
        sprite.setBounds(initX, initY, initWidth, initHeight);
    }
    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        BufferedImage newImage = new BufferedImage(resultingImage.getWidth(null), resultingImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(resultingImage, 0, 0, null);
        g.dispose();
        return newImage;
    }
    public void gravityCalc() {
        yVel += 1;
    }
    public void checkCollision(Object reference) {
        // 1. THIS collides with bottom of REFERENCE Object while going up
        // 2. THIS collides with right of REFERENCE Object while going left
        // 3. THIS collides with top of REFERENCE Object while going down
        // 4. THIS collides with left of REFERENCE Object while going right
        boolean[] collisions = {false, false, false, false};
        int minXThis = xPos + xVel;
        int maxXThis = xPos + width + xVel;
        int minYThis = yPos + height + yVel;
        int maxYThis = yPos + yVel;
        int minXReference = reference.getX();
        int maxXReference = reference.getX() + reference.getWidth();
        int minYReference = reference.getY() + reference.getHeight();
        int maxYReference = reference.getY();
        boolean xClip = (maxYThis < maxYReference && minYThis > maxYReference)
        || (minYThis > minYReference && maxYThis < minYReference) ||
        (maxYThis > maxYReference && minYThis < minYReference);
        boolean yClip = (maxXThis > maxXReference && minXThis < maxXReference)
        || (minXThis < minXReference && maxXThis > minXReference) ||
        (maxXThis < maxXReference && minXThis > minXReference);
        if(maxYThis < maxYReference && minYThis > maxYReference && yClip) {
            collisions[2] = true;
            jump = 1;
            yPos += yVel - (minYThis - maxYReference);
            yVel = 0;
        }
        if(minYThis > minYReference && maxYThis < minYReference && yClip) {
            yVel = minYReference - maxYThis;
            collisions[0] = true;
            if(yVel < 0) {
                yVel = 0;
            }
        }
        if(maxXThis > maxXReference && minXThis == maxXReference && xClip) {
            collisions[1] = true;
            if(xVel < 0) {
                xVel = 0;
            }
        }
        if(minXThis < minXReference && maxXThis == minXReference && xClip) {
            collisions[3] = true;
            if(xVel > 0) {
                xVel = 0;
            }
        }
    }
    public JLabel getSprite() {
        return sprite;
    }
    public void move(int x, int y) {
        sprite.setBounds(x, y, width, height);
    }
    public void setX(int x) {
        xPos = x;
    }
    public void setY(int y) {
        yPos = y;
    }
    public void setXVelocity(int x) {
        xVel = x;
    }
    public void setYVelocity(int y) {
        yVel = y;
    }
    public int getX() {
        return xPos;
    }
    public int getY() {
        return yPos;
    }
    public int getXVel() {
        return xVel;
    }
    public int getYVel() {
        return yVel;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getJump() {
        return jump;
    }
    public void subtractJump() {
        jump -= 1;
    }
}
