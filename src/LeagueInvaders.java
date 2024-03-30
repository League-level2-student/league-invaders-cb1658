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
 * v1.2-pre1: Every game, you are given two powerups which wipe out the entire screen (Click SHIFT)
 * v1.2-pre2: Added an ammunitions/powerup bar and have the rocket reload when out of ammunitions (this took me two hours *sobs*)
 * v1.2-pre3: You can now reload whenever you want by clicking (R). I fixed an issue where it will carry over from the last round
 * v1.2-pre4: You can no longer reload when at full ammo. Wave rates set back to normal.
 * v1.2: Q can be used to quit. Powerups no longer add to the score. Score is shown at end of game. Ammo 150 --> 100.
 * 
 * v1.2.1: Now, when you are running out or are out of ammo or powerups, they turn orange and red. Revamped the "help" menu button.
 * 
 * v1.3-pre1: The game now speeds up with increasing score. Doesnt work.
 * v1.3-pre2: Fixed! Only after three weeks...
 * 			  Known Issues: Speed does not reset after each game properly.
 * v1.3: Ammo Powerups are now spawning which increase ammo by 30. Ammo still cannot go over 100 however.
 * 		 When ammo is at full, it is given a green tint. Ammo powerups do not work while reloading.
 *            
 * 
 * THINGS TO BE DONE: 
 * 
 * -Add more powerups where you gain ammunitions or something like that (v1.3)
 * -Add indestructable alien (v1.3)
 * -Add Menus for different difficulties (v1.3)
 * -Aliens can shoot back at random (v1.3.1)
 * -Add a leaderboard of highscores with initials (v1.4)
 * -Add different bullets: buckshot, shrapnel (v1.4)
 *  -Add explosion animation (v1.5)
 * 
 */
