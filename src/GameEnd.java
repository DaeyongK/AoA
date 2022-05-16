import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameEnd extends JPanel { //displays images correctly
    String winner;
    private BufferedImage img;
    private JButton playAgain;
    private JButton exitGame;
    GameEnd(String w) {
        super();
        winner = w;
        setLayout(null);
        File resource = new File("Images/PlayerOneScreen.png");
        if (winner.equals("two")) {
            resource = new File("Images/PlayerTwoScreen.png");
        }
        try {
            img = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        exitGame = new JButton();
        exitGame.setBounds(585,600,150,50);
        playAgain = new JButton();
        playAgain.setBounds(585,400,150,50);
        add(exitGame);
        add(playAgain);

    }
    public void end() {
        System.out.println(winner);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img,0,0,this);


    }
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == exitGame) {
            //i believe these are the two ways to change between the screens

        } else if (event.getSource() == playAgain) {

        }
    }
}
//
//    Exception in thread "AWT-EventQueue-0" java.lang.ArrayIndexOutOfBoundsException: No such child: 19
//        at java.desktop/java.awt.Container.getComponent(Container.java:350)
//        at java.desktop/javax.swing.JComponent.rectangleIsObscured(JComponent.java:4426)
//        at java.desktop/javax.swing.JComponent.paint(JComponent.java:1072)
//        at java.desktop/javax.swing.JComponent.paintToOffscreen(JComponent.java:5255)
//        at java.desktop/javax.swing.RepaintManager$PaintManager.paintDoubleBufferedImpl(RepaintManager.java:1643)
//        at java.desktop/javax.swing.RepaintManager$PaintManager.paintDoubleBuffered(RepaintManager.java:1618)
//        at java.desktop/javax.swing.RepaintManager$PaintManager.paint(RepaintManager.java:1556)
//        at java.desktop/javax.swing.RepaintManager.paint(RepaintManager.java:1323)
//        at java.desktop/javax.swing.JComponent._paintImmediately(JComponent.java:5203)
//        at java.desktop/javax.swing.JComponent.paintImmediately(JComponent.java:5013)
//        at java.desktop/javax.swing.RepaintManager$4.run(RepaintManager.java:865)
//        at java.desktop/javax.swing.RepaintManager$4.run(RepaintManager.java:848)
//        at java.base/java.security.AccessController.doPrivileged(AccessController.java:391)
//        at java.base/java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:85)
//        at java.desktop/javax.swing.RepaintManager.paintDirtyRegions(RepaintManager.java:848)
//        at java.desktop/javax.swing.RepaintManager.paintDirtyRegions(RepaintManager.java:823)
//        at java.desktop/javax.swing.RepaintManager.prePaintDirtyRegions(RepaintManager.java:772)
//        at java.desktop/javax.swing.RepaintManager$ProcessingRunnable.run(RepaintManager.java:1884)
//        at java.desktop/java.awt.event.InvocationEvent.dispatch(InvocationEvent.java:316)
//        at java.desktop/java.awt.EventQueue.dispatchEventImpl(EventQueue.java:770)
//        at java.desktop/java.awt.EventQueue$4.run(EventQueue.java:721)
//        at java.desktop/java.awt.EventQueue$4.run(EventQueue.java:715)
//        at java.base/java.security.AccessController.doPrivileged(AccessController.java:391)
//        at java.base/java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:85)
//        at java.desktop/java.awt.EventQueue.dispatchEvent(EventQueue.java:740)
//        at java.desktop/java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:203)
//        at java.desktop/java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:124)
//        at java.desktop/java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:113)
//        at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:109)
//        at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:101)
//        at java.desktop/java.awt.EventDispatchThread.run(EventDispatchThread.java:90)

