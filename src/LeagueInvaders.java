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
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(gp);
	}
	
}

/* DEVELOPMENT VERSION LIST (for the fun of it)
 * 
 * v0.0: Menu
 * v0.1: Key Detection
 * 
 * v0.2.0: Rocket
 * v0.2.1: ObjectManager
 * v0.2.2: Images (Rocket, Alien, Projectile)
 * v0.2.3: Rocket Movement Improvement
 * 
 * v0.3: Falling Aliens/Projectiles Added
 * 
 * v1.0-pre1: Collision detection added but it doesn't work
 * v1.0-pre2: Collision detection works but now when you die pressing enter makes it go from MENU to END forever
 * v1.0: Bugs fixed and score added
 * v1.0.1: Alien wave 1 added
 * 
 * THINGS TO BE DONE: 
 * 
 * -Add explosion animation (v1.0.2)
 * -Add waves (v1.1)
 * -Add different aliens (v1.2)
 * 
 */
