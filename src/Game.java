import javax.swing.*;
import java.io.IOException;
public class Game {
	private JFrame frame;
	private ImageIcon backgroundIcon;
	private JLabel backgroundLabel;
	private GameScreen contentPane;
	private Pvemode pvePane;
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
		frame.revalidate();
		while(true) {
			Thread.sleep(10);
			if(state.equals("PVP")) {
				contentPane = new GameScreen();
				frame.setContentPane(contentPane);
				frame.revalidate();
				contentPane.run();
			} else if(state.equals("EXIT")) {
				System.exit(0);
			} else if(state.equals("PVE")) {
				pvePane = new Pvemode();
				frame.setContentPane(pvePane);
				frame.revalidate();
				pvePane.run();
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
