import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameScreen extends JPanel{
    private Player1 pl1;

    GameScreen() throws IOException {
        super();
        setLayout(null);
        setBackground(new Color(255,255,255));
        pl1 = new Player1(new File("images/BaseCharacterImagepng.png"), this,10, 650, 150, 200);
        add(pl1.getSprite());
        setFocusable(true);
        addKeyListener(new MyKeyListener(pl1));
    }
    public void run() throws InterruptedException {
        while(true) {
            Thread.sleep(10);
            pl1.setX(pl1.getX()+pl1.getXVel());
            pl1.setY(pl1.getY()+pl1.getYVel());
            pl1.move(pl1.getX(), pl1.getY());
        }
    }
}
