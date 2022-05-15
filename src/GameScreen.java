import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class GameScreen extends JPanel{
    private static Object healthb1, healthb2, health1, health2;
    private Player1 pl1;
    private Player2 pl2;
    private Platform bottom, l1, l2, l3, h1, h2, bl, bt, br;
    private ArrayList<Object> allObjects = new ArrayList<Object>();
    private ArrayList<Projectile> allProjectiles = new ArrayList<Projectile>();
    GameScreen() throws IOException {
        super();
        setLayout(null);
        setBackground(new Color(255,255,255));
        healthb1 = new Object(new File("Images/healthbackground.png"), 50, 50, 300, 30);
        healthb2 = new Object(new File("Images/healthbackground.png"), 1050, 50, 300, 30);
        health1 = new Object(new File("Images/healthbar.png"), 50, 50, 300, 30);
        health2 = new Object(new File("Images/healthbar.png"), 1050, 50, 300, 30);
        pl1 = new Player1(new File("Images/Kaguya/Kaguya_Walking_One.png"),10, 100, 30, 100);
        pl2 = new Player2(new File("Images/Kaguya/Kaguya_Walking_One.png"), 1330, 100, 30, 100);
        pl2.setACount(1);
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
        add(health1.getSprite());
        add(health2.getSprite());
        add(healthb1.getSprite());
        add(healthb2.getSprite());
        allObjects.add(bottom);
        allObjects.add(l1);
        allObjects.add(l2);
        allObjects.add(l3);
        allObjects.add(h1);
        allObjects.add(h2);
        allObjects.add(bl);
        allObjects.add(bt);
        allObjects.add(br);
        setFocusable(true);
        addKeyListener(new MyKeyListener(pl1, pl2));
    }
    public static Object getHealth1() {
        return health1;
    }
    public static Object getHealth2() {
        return health2;
    }
    public String run() throws InterruptedException, IOException {
        requestFocus();
        Player[] players = {pl1, pl2};
        String winner = "None";
        boolean running = true;
        while(running) {
            Thread.sleep(10);
            for(Player p : players) {
                if(p.getLoveLetter()) {
                    Projectile l = p.loveLetter();
                    if(l!=null) {
                        add(l.getSprite());
                        allProjectiles.add(l);
                    }
                } else {
                    if(p.getXVel() > 0) {
                        p.setACount(0);
                        p.setDCount(p.getDCount() + 1);
                        if(p.getOne() && p.getDCount() % 9 == 0) {
                            p.changeSprite(p.getWalkTwoRight());
                            p.setOne(false);
                        } else if (!p.getOne() && p.getDCount() % 9 == 0){
                            p.changeSprite(p.getWalkOneRight());
                            p.setOne(true);
                        }
                    } else if(p.getXVel() < 0){
                        p.setDCount(0);
                        p.setACount(p.getACount() + 1);
                        if(p.getOne() && p.getACount() % 9 == 0) {
                            p.changeSprite(p.getWalkTwoLeft());
                            p.setOne(false);
                        } else if (!p.getOne() && p.getACount() % 9 == 0){
                            p.changeSprite(p.getWalkOneLeft());
                            p.setOne(true);
                        }
                    } else {
                        if(p.getACount()==0) {
                            p.changeSprite(p.getWalkOneRight());
                        } else {
                            p.changeSprite(p.getWalkOneLeft());
                        }
                    }
                }
                for(Object o : allObjects) {
                    p.checkCollision(o);
                }
                Iterator<Projectile> itr = allProjectiles.iterator();
                while(itr.hasNext()) {
                    Projectile proj = itr.next();
                    if(p.checkCollision(proj)) {
                        p.setHealth(p.getHealth()-proj.getDamage());
                        allProjectiles.remove(proj);
                        remove(proj.getSprite());
                        repaint();
                        itr = allProjectiles.iterator();
                    }
                    for(Object o : allObjects) {
                        if(proj.checkCollision(o)) {
                            allProjectiles.remove(proj);
                            remove(proj.getSprite());
                            repaint();
                            itr = allProjectiles.iterator();
                        }
                    }
                }
                if(p==pl1) {
                    p.checkCollision(pl2);
                } else {
                    p.checkCollision(pl1);
                }
                p.gravityCalc();
                p.setX(p.getX()+p.getXVel());
                p.setY(p.getY()+p.getYVel());
                p.move(p.getX(), p.getY());
                for(Projectile proj : allProjectiles) {
                    proj.setX(proj.getX() + proj.getXVel());
                    proj.setY(proj.getY() + proj.getYVel());
                    proj.move(proj.getX(), proj.getY());
                }
                if(p.getHealth() <= 0) {
                    running = false;
                    if(p == pl1) {
                        winner = "Player 2";
                    } else {
                        winner = "Player 1";
                    }
                }
            }
        }
        return winner;
    }
}
