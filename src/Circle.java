import javax.swing.border.Border;
import java.awt.*;
class Circle implements Border {
    public int r;
    public Color color, bcolor;
    Graphics2D g2;
    Circle(int r, Color c, Color bc) {
        this.r = r;
        this.color = c;
        this.bcolor = bc;
    }
    public Insets getBorderInsets(Component c) {
        return new Insets(this.r+1, this.r+1, this.r+2, this.r);
    }
    public boolean isBorderOpaque() {
        return true;
    }
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(x, y, width-1, height-1, r, r);
        if(bcolor!=null) {
            g2.setColor(bcolor);
            g2.fillRoundRect(x, y, width-1, height-1, r, r);
        }
    }
}