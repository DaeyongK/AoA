import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
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
	public Game() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Attack on Anime");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new MyDispatcher());
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255,255,255));
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(1400, 850);
	}
}
