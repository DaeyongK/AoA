import java.io.File;
import java.io.IOException;
public class Platform extends Object {
    Platform(File spriteFile, GameScreen gameScreen, int initX, int initY, int initWidth, int initHeight) throws IOException {
        super(spriteFile, gameScreen, initX, initY, initWidth, initHeight, 0);
    }
}
