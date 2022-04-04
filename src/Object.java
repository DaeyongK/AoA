import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Object {
    private JLabel sprite;
    private int xPos, yPos, xVel, yVel, width, height;
    private GameScreen gs;
    Object(File spriteFile, GameScreen gameScreen, int initX, int initY, int initWidth, int initHeight) throws IOException {
        xPos = initX;
        yPos = initY;
        width = initWidth;
        height = initHeight;
        sprite = new JLabel(new ImageIcon(resizeImage(ImageIO.read(spriteFile), initWidth,initHeight)));
        sprite.setBounds(initX, initY, initWidth, initHeight);
        gs = gameScreen;
    }
    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        BufferedImage newImage = new BufferedImage(resultingImage.getWidth(null), resultingImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(resultingImage, 0, 0, null);
        g.dispose();
        return newImage;
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
}
