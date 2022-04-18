import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
public class Game {
	private JFrame frame;
	private GameScreen contentPane;
	public GameScreen getGameScreen() {
		return contentPane;
	}
	public Game() throws IOException, InterruptedException {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Attack on Anime");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new GameScreen();
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
		frame.repaint();
		frame.setSize(1400, 950);
		contentPane.run();
	}
}
