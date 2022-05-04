import java.io.File;
import java.io.IOException;
public class Projectile extends Object {
    private int damage;
    Projectile(File spriteFile, int initX, int initY, int initWidth, int initHeight, int xv, int yv, int dmg) throws IOException {
        super(spriteFile, initX, initY, initWidth, initHeight);
        setXVelocity(xv);
        setYVelocity(yv);
        damage = dmg;
    }
    public int getDamage() {
        return damage;
    }
}
