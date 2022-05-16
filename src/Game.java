import javax.swing.*;
import java.io.IOException;
public class Game {
	private JFrame frame;
	private GameScreen contentPane;
	private PveMode pvePane;
	private P1Win p1w;
	private P2Win p2w;
	private PveWin pvew;
	private StartScreen start;
	private String winner;
	private int finalScore;
	private static String state = "";
	private static boolean decided = true;
	public Game() throws IOException, InterruptedException {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Attack on Anime");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.repaint();
		frame.setSize(1400, 950);
		boolean game = true, cont;
		while(game) {
			start = new StartScreen();
			frame.setContentPane(start);
			frame.revalidate();
			cont = true;
			while(cont) {
				Thread.sleep(10);
				if(decided) {
					if(state.equals("PVP")) {
						contentPane = new GameScreen();
						frame.setContentPane(contentPane);
						frame.revalidate();
						winner = contentPane.run();
						decided = false;
						if(winner == "Player 1") {
							p1w = new P1Win();
							frame.setContentPane(p1w);
							frame.revalidate();
						} else if(winner == "Player 2") {
							p2w = new P2Win();
							frame.setContentPane(p2w);
							frame.revalidate();
						}
					} else if(state.equals("EXIT")) {
						System.exit(0);
					} else if(state.equals("PVE")) {
						pvePane = new PveMode();
						frame.setContentPane(pvePane);
						frame.revalidate();
						finalScore = pvePane.run();
						decided = false;
						pvew = new PveWin(finalScore);
						frame.setContentPane(pvew);
						frame.revalidate();
					} else if(state.equals("REDO")) {
						cont = false;
					}
				}
			}
		}
	}
	public static void setState(String st) {
		state = st;
	}
	public static void setDecided(boolean b) {
		decided = b;
	}
}
