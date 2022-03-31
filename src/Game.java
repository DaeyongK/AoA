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
	private JPanel contentPane;
	private char curLet;
	private class MyDispatcher implements KeyEventDispatcher {
		public boolean dispatchKeyEvent(KeyEvent e) {
			if (e.getID() == KeyEvent.KEY_PRESSED) {
				curLet = e.getKeyChar();
			}
			return false;
		}
	}
	private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
		Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
		BufferedImage newImage = new BufferedImage(resultingImage.getWidth(null), resultingImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = newImage.createGraphics();
		g.drawImage(resultingImage, 0, 0, null);
		g.dispose();
		return newImage;
	}
	public Game() throws IOException {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Attack on Anime");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new MyDispatcher());
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255,255,255));
		BufferedImage p1 = resizeImage(ImageIO.read(new File("images/BaseCharacterImagepng.png")), 300,400);
		JLabel pl1 = new JLabel(new ImageIcon(p1));
		pl1.setBounds(0, 0, 300, 400);
		contentPane.add(pl1);
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) size.getWidth();
		int height = (int) size.getHeight();
		frame.repaint();
		frame.setSize(width, height);
	}
}
