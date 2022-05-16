import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class CircularButton extends JButton implements ActionListener {
    private String type;
    CircularButton(int xCoord, int yCoord, int r, Color c, Color bc,
    String t) {
        super();
        type = t;
        this.setBounds(xCoord, yCoord, r, r);
        this.setBorder(new Circle(r, c, bc));
        this.addActionListener(this);
    }
    public void actionPerformed(ActionEvent event) {
        if(type.equals("EXIT")) {
            Game.setDecided(true);
            System.exit(0);
        } else if(type.equals("PVP")) {
            Game.setState("PVP");
        } else if(type.equals("PVE")) {
            Game.setState("PVE");
        } else if(type.equals("REPLAY")) {
            Game.setState("REPLAY");
        } else if(type.equals("REDO")) {
            Game.setDecided(true);
            Game.setState("REDO");
        }
    }
}