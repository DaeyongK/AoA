import javax.swing.*;
import java.io.IOException;
public class Game {
	private JFrame frame;
	private GameScreen contentPane;
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
