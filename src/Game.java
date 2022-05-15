import javax.swing.*;
import java.io.IOException;
public class Game {
	private JFrame frame;
	private GameScreen contentPane;
	private StartScreen start;
	private GameEnd gameEnd;
	private String winner;
	private static String state = "";
	public Game() throws IOException, InterruptedException {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Attack on Anime");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.repaint();
		frame.setSize(1400, 950);
		start = new StartScreen();
		frame.setContentPane(start);

		while(true) {
			Thread.sleep(10);
			if(state.equals("PVP")) {
				contentPane = new GameScreen();
				frame.setContentPane(contentPane);
				frame.revalidate();
				contentPane.run();
			} else if(state.equals("EXIT")) {
				System.exit(0);
			}
		}

//
//		winner = contentPane.run();
//		gameEnd = new GameEnd(winner);
//		frame.setContentPane(gameEnd);
//		frame.repaint();
//		gameEnd.end();
	}
	public static void setState(String st) {
		state = st;
	}
}
