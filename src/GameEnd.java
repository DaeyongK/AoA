import javax.swing.*;

public class GameEnd extends JPanel {
    String winner;
    GameEnd(String w) {
        super();
        winner = w;
    }
    public void end() {
        System.out.println(winner);
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