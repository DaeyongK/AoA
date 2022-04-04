import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
public class Player1 extends Player {
    Player1(File spriteFile, GameScreen gameScreen, int initX, int initY, int initWidth, int initHeight) throws IOException {
        super(spriteFile, gameScreen, initX, initY, initWidth, initHeight);
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            setYVelocity(-5);
        } else if (e.getKeyChar() == 'a') {
            setXVelocity(-5);
            System.out.println("WOOOO");
        } else if (e.getKeyChar() == 's') {
            setYVelocity(5);
        } else if (e.getKeyChar() == 'd') {
            setXVelocity(5);
            System.out.println("P");
        }
    }
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            setYVelocity(0);
        } else if (e.getKeyChar() == 'a') {
            setXVelocity(0);
        } else if (e.getKeyChar() == 's') {
            setYVelocity(0);
        } else if (e.getKeyChar() == 'd') {
            setXVelocity(0);
        }
    }
//    https://www.google.com/search?q=key+bindings+to+jpanel+java+swing&sxsrf=APq-WBsGGjCtbXoy6FpYi1gtpvsN7mVK7A%3A1649031659913&ei=6zlKYsKyN6yalwS66p2oBw&ved=0ahUKEwiC1L_Skfn2AhUszYUKHTp1B3UQ4dUDCA4&uact=5&oq=key+bindings+to+jpanel+java+swing&gs_lcp=Cgdnd3Mtd2l6EAMyBQghEKABMgUIIRCgAToHCAAQRxCwAzoECCMQJzoKCAAQgAQQhwIQFDoFCAAQgAQ6BggAEBYQHjoFCAAQhgM6CAghEBYQHRAeOgcIIRAKEKABOgQIIRAKOgUIIRCrAkoECEEYAEoECEYYAFC3BljNF2CAGGgBcAB4AYAB1gGIAaEOkgEGMTcuMi4xmAEAoAEByAEIwAEB&sclient=gws-wiz#kpvalbx=_izpKYr7DO7WlptQPk-W64Ag23
}
