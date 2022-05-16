import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;
public class PveMode extends JLayeredPane {
    private Player1 pl1;
    private Platform bottom, l1, l2, l3, h1, h2, bl, bt, br;
    private ArrayList<Object> allObjects = new ArrayList<>();
    private ArrayList<Object> allBalloons = new ArrayList<>();
    private ArrayList<Projectile> allProjectiles = new ArrayList<>();
    private JLabel backgroundImage;
    private JLabel points, time;
    private int balloonsPopped = 0, seconds = 60;
    PveMode() throws IOException {
        super();
        setLayout(null);
        setBackground(new Color(255,255,255));
        backgroundImage = new Object(new File("Images/backgroundSprite.png"), 0, 0, 1400, 950).getSprite();
        points = new JLabel("Points: " + balloonsPopped);
        points.setBounds(400, 0, 200, 50);
        time = new JLabel("Time: " + seconds);
        time.setBounds(700, 0, 200, 50);
        pl1 = new Player1(new File("Images/Kaguya/Kaguya_Walking_One.png"),10, 100, 30, 100);
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
        add(bottom.getSprite());
        add(l1.getSprite());
        add(l2.getSprite());
        add(l3.getSprite());
        add(h1.getSprite());
        add(h2.getSprite());
        add(bl.getSprite());
        add(bt.getSprite());
        add(br.getSprite());
        add(points);
        add(time);
        add(backgroundImage);
        moveToBack(backgroundImage);
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
        addKeyListener(new MyKeyListener(pl1));
    }
    public void generateBalloons() throws IOException {
        boolean allBalloonsGenerated = false;
        int bCount = 0;
        while(!allBalloonsGenerated) {
            boolean illegal = true;
            int x = 0;
            int y = 0;
            while(illegal) {
                x = ThreadLocalRandom.current().nextInt(5, 1375);
                y = ThreadLocalRandom.current().nextInt(5, 925);
                illegal = false;
                for(Object o : allObjects) {
                    int minXReference = o.getX();
                    int maxXReference = o.getX() + o.getWidth();
                    int minYReference = o.getY() + o.getHeight();
                    int maxYReference = o.getY();
                    boolean xClip = (y <= maxYReference && y+50 > maxYReference)
                            || (y+50 >= minYReference && y < minYReference) ||
                            (y > maxYReference && y+50 < minYReference);
                    boolean yClip = (x+20 >= maxXReference && x < maxXReference)
                            || (x <= minXReference && x+20 > minXReference) ||
                            (x+20 < maxXReference && x > minXReference);
                    if((y < maxYReference && y+50 >= maxYReference && yClip && !(y+50 >= minYReference)) ||
                    (y+50 > minYReference && y <= minYReference && yClip) || (x+20 > maxXReference && x <= maxXReference && xClip) ||
                    (x < minXReference && x+20 >= minXReference && xClip) ||
                    (x >= minXReference && x+20 <= maxXReference && y >= maxYReference && y+50 <= minYReference)) {
                        illegal = true;
                    }
                }
            }
            bCount++;
            Object balloon = new Object(new File("Images/BalloonSprite_One.png"), x, y, 25, 70);
            allBalloons.add(balloon);
            add(balloon.getSprite());
            moveToFront(balloon.getSprite());
            if(bCount==3) {
                allBalloonsGenerated = true;
            }
        }
    }
    public int run() throws InterruptedException, IOException {
        long startTime = System.currentTimeMillis();
        requestFocus();
        boolean running = true;
        boolean generateOK = true;
        while(running) {
            if(balloonsPopped % 3 == 0 && generateOK) {
                generateBalloons();
                generateOK = false;
            }
            Thread.sleep(10);
            time.setText("Time: " + (60 - (int) (System.currentTimeMillis() - startTime) / 1000));
            if(60 - (int) ((System.currentTimeMillis() - startTime) / 1000) <= 0) {
                running = false;
            }
            if(pl1.getLoveLetter()) {
                Projectile l = pl1.loveLetter();
                if(l!=null) {
                    add(l.getSprite());
                    moveToFront(l.getSprite());
                    allProjectiles.add(l);
                }
            } else {
                if(pl1.getXVel() > 0) {
                    pl1.setACount(0);
                    pl1.setDCount(pl1.getDCount() + 1);
                    if(pl1.getOne() && pl1.getDCount() % 9 == 0) {
                        pl1.changeSprite(pl1.getWalkTwoRight());
                        pl1.setOne(false);
                    } else if (!pl1.getOne() && pl1.getDCount() % 9 == 0){
                        pl1.changeSprite(pl1.getWalkOneRight());
                        pl1.setOne(true);
                    }
                } else if(pl1.getXVel() < 0){
                    pl1.setDCount(0);
                    pl1.setACount(pl1.getACount() + 1);
                    if(pl1.getOne() && pl1.getACount() % 9 == 0) {
                        pl1.changeSprite(pl1.getWalkTwoLeft());
                        pl1.setOne(false);
                    } else if (!pl1.getOne() && pl1.getACount() % 9 == 0){
                        pl1.changeSprite(pl1.getWalkOneLeft());
                        pl1.setOne(true);
                    }
                } else {
                    if(pl1.getACount()==0) {
                        pl1.changeSprite(pl1.getWalkOneRight());
                    } else {
                        pl1.changeSprite(pl1.getWalkOneLeft());
                    }
                }
            }
            for(Object o : allObjects) {
                pl1.checkCollision(o);
            }
            Iterator<Projectile> itr = allProjectiles.iterator();
            while(itr.hasNext()) {
                Projectile proj = itr.next();
                Iterator<Object> bitr = allBalloons.iterator();
                while(bitr.hasNext()) {
                    Object b = bitr.next();
                    if(proj.checkCollision(b)) {
                        allProjectiles.remove(proj);
                        remove(proj.getSprite());
                        allBalloons.remove(b);
                        remove(b.getSprite());
                        balloonsPopped++;
                        points.setText("Points: " + balloonsPopped);
                        generateOK = true;
                        repaint();
                        bitr = allBalloons.iterator();
                        itr = allProjectiles.iterator();
                    }
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
            pl1.gravityCalc();
            pl1.setX(pl1.getX()+pl1.getXVel());
            pl1.setY(pl1.getY()+pl1.getYVel());
            pl1.move(pl1.getX(), pl1.getY());
            for(Projectile proj : allProjectiles) {
                proj.setX(proj.getX() + proj.getXVel());
                proj.setY(proj.getY() + proj.getYVel());
                proj.move(proj.getX(), proj.getY());
            }
        }
        return balloonsPopped;
    }
}
