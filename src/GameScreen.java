import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
public class GameScreen extends JPanel{
    private Player1 pl1;
    private Player2 pl2;
    private Platform bottom, l1, l2, l3, h1, h2, bl, bt, br;
    GameScreen() throws IOException {
        super();
        setLayout(null);
        setBackground(new Color(255,255,255));
        pl1 = new Player1(new File("images/Kaguya_Walking_One.png"),10, 100, 35, 100);
        pl2 = new Player2(new File("images/Kaguya_Walking_One.png"), 1330, 100, 35, 100);
        bottom = new Platform(new File("images/platform.png"), 0, 825, 1400, 100);
        l1 = new Platform(new File("images/platform.png"), 250, 620, 200, 50);
        l2 = new Platform(new File("images/platform.png"), 600, 620, 200, 50);
        l3 = new Platform(new File("images/platform.png"), 950, 620, 200, 50);
        h1 = new Platform(new File("images/platform.png"), 300, 380, 300, 50);
        h2 = new Platform(new File("images/platform.png"), 800, 380, 300, 50);
        bl = new Platform(new File("images/bound.png"), -100, -100, 100, 1500);
        bt = new Platform(new File("images/bound.png"), -100, -100, 1500, 100);
        br = new Platform(new File("images/bound.png"), 1400, -100, 100, 1500);
        add(pl1.getSprite());
        add(pl2.getSprite());
        add(bottom.getSprite());
        add(l1.getSprite());
        add(l2.getSprite());
        add(l3.getSprite());
        add(h1.getSprite());
        add(h2.getSprite());
        add(bl.getSprite());
        add(bt.getSprite());
        add(br.getSprite());
        setFocusable(true);
        addKeyListener(new MyKeyListener(pl1, pl2));
    }
    public void run() throws InterruptedException {
        Player[] players = {pl1, pl2};
        while(true) {
            Thread.sleep(10);
            for(Player p : players) {
                p.checkCollision(bottom);
                p.checkCollision(bl);
                p.checkCollision(bt);
                p.checkCollision(br);
                p.checkCollision(l1);
                p.checkCollision(l2);
                p.checkCollision(l3);
                p.checkCollision(h1);
                p.checkCollision(h2);
                if(p==pl1) {
                    p.checkCollision(pl2);
                } else {
                    p.checkCollision(pl1);
                }
                p.gravityCalc();
                p.setX(p.getX()+p.getXVel());
                p.setY(p.getY()+p.getYVel());
                p.move(p.getX(), p.getY());
            }
        }
    }
}
