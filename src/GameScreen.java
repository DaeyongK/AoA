import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
public class GameScreen extends JPanel{
    private static Object healthb1, healthb2, health1, health2;
    private Player1 pl1;
    private Player2 pl2;
    private Platform bottom, l1, l2, l3, h1, h2, bl, bt, br;
    GameScreen() throws IOException {
        super();
        setLayout(null);
        setBackground(new Color(255,255,255));
        healthb1 = new Object(new File("Images/healthbackground.png"), 50, 50, 300, 30);
        healthb2 = new Object(new File("Images/healthbackground.png"), 1050, 50, 300, 30);
        health1 = new Object(new File("Images/healthbar.png"), 50, 50, 300, 30);
        health2 = new Object(new File("Images/healthbar.png"), 1050, 50, 300, 30);
        pl1 = new Player1(new File("Images/Kaguya/Kaguya_Walking_One.png"),10, 100, 35, 100);
        pl2 = new Player2(new File("Images/Kaguya/Kaguya_Walking_One.png"), 1330, 100, 35, 100);
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
        setFocusable(true);
        addKeyListener(new MyKeyListener(pl1, pl2));
    }
    public static Object getHealth1() {
        return health1;
    }
    public static Object getHealth2() {
        return health2;
    }
    public void run() throws InterruptedException {
        Player[] players = {pl1, pl2};
        boolean running = true;
        while(running) {
            Thread.sleep(10);
            for(Player p : players) {
                if(p.getLoveLetter()) {
                    if(p.getAniFrameOrder() == 0) {
                        p.setStartTime();
                        if(p.getLeftFacing()) {
                            p.changeSprite(p.getF1R());
                        } else {
                            p.changeSprite(p.getF1());
                        }
                        p.setAniFrameOrder(p.getAniFrameOrder()+1);;
                    } else if(p.getAniFrameOrder() == 1 && (System.currentTimeMillis() - p.getStartTime()) > 75) {
                        if(p.getLeftFacing()) {
                            p.changeSprite(p.getF2R());
                        } else {
                            p.changeSprite(p.getF2());
                        }
                        p.setAniFrameOrder(p.getAniFrameOrder()+1);;
                    } else if(p.getAniFrameOrder() == 2 && (System.currentTimeMillis() - p.getStartTime()) > 150) {
                        if(p.getLeftFacing()) {
                            p.changeSprite(p.getF3R());
                        } else {
                            p.changeSprite(p.getF3());
                        }
                        p.setAniFrameOrder(p.getAniFrameOrder()+1);;
                    } else if(p.getAniFrameOrder() == 3 && (System.currentTimeMillis() - p.getStartTime()) > 225) {
                        if(p.getLeftFacing()) {
                            p.changeSprite(p.getF4R());
                        } else {
                            p.changeSprite(p.getF4());
                        }
                        p.setAniFrameOrder(p.getAniFrameOrder()+1);;
                    } else if(p.getAniFrameOrder() == 4 && (System.currentTimeMillis() - p.getStartTime()) > 300) {
                        if(p.getLeftFacing()) {
                            p.changeSprite(p.getWalkOneLeft());
                        } else {
                            p.changeSprite(p.getWalkOneRight());
                        }
                        p.setLoveLetter(false);
                        p.setAniFrameOrder(0);;
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
