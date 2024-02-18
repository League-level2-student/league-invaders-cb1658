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
 * v1.1-pre1: Diagonal Aliens have been added (they function properly! yay!)
 * v1.1-pre2: Weirdos added
 * v1.1: Waves 2 and 3 added
 * 
 * v1.1.1: Optimized Shooting/Moved GamePanel alienTimer to ObjectManager
 * v1.1.2: ThisWaveWillEndYou
 * v1.1.3: Diagonal Aliens can now start moving left or right. Wave rates have been set back to normal. Several other Diagonal Alien improvements
 * 
 * v1.2-pre1: Every game, you are given two powerups which wipe out the entire screen
 * v1.2-pre2: Added an ammunitions/powerup bar and have the rocket reload when out of ammunitions (this took me two hours *sobs*)
 * 
 * THINGS TO BE DONE: 
 * 
 * -Make game go faster for increasing score (v1.2)
 * -Add explosion animation (v1.2)
 * -Add indestructable alien (v1.3)
 * -Add Menus for different difficulties (v1.3)
 * -Aliens can shoot back at random (v1.3.1)
 * -Add different bullets: buckshot, shrapnel (v1.4)
 * 
 */
