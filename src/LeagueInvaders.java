import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	
	JFrame frame = new JFrame();
	
	public final static int WIDTH = 1000;
	public final static int HEIGHT = 1000;
	
	GamePanel gp;
	
	public LeagueInvaders() {
		gp = new GamePanel();
	}
	
	public static void main(String[] args) {
		
		LeagueInvaders li = new LeagueInvaders();
		li.initialize();
		
	}
	
	public void initialize() {
		
		frame.add(gp);
		gp.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.pack();
		//frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(gp);
	}
	
}

/* VERSION LIST (for the fun of it)
 * 
 * v0.0.0: Runner
 * v0.0.1: Game Background
 * v0.0.2: State Change
 * v0.0.3: Text
 * 
 * v0.1.0: Timer
 * v0.1.1: Key Detection
 * 
 * v0.2.0: Rocket Draw
 * v0.2.1: Rocket Variables Encapsulated
 * v0.2.2: Rocket Movement
 * 
 */
