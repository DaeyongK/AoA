import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class GameScreen extends JPanel{
    private Player1 pl1;
    private Platform bottom, left, right;

    GameScreen() throws IOException {
        super();
        setLayout(null);
        setBackground(new Color(255,255,255));
        pl1 = new Player1(new File("images/BaseCharacterImagepng.png"), this,10, 550, 120, 160);
        bottom = new Platform(new File("images/platform.png"), this, 0, 750, 1400, 100);
        left = new Platform(new File("images/platform.png"), this, 600, 300, 600, 100);
        right = new Platform(new File("images/platform.png"), this, 300, 200, 600, 100);
        add(pl1.getSprite());
        add(bottom.getSprite());
        add(left.getSprite());
        add(right.getSprite());
        setFocusable(true);
        addKeyListener(new MyKeyListener(pl1));
    }
    public void run() throws InterruptedException {
        boolean[] collisions;
        while(true) {
            Thread.sleep(10);
            pl1.checkCollision(bottom);
            pl1.checkCollision(left);
            pl1.checkCollision(right);
            pl1.setX(pl1.getX()+pl1.getXVel());
            pl1.setY(pl1.getY()+pl1.getYVel());
            pl1.move(pl1.getX(), pl1.getY());

        }
    }
}
