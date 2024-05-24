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

/* VERSION 0/1 PATCH NOTES
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
 * v1.3.1: Good Ammo now has a plus sign. Bad ammo added. Removes 30 ammo and has minus sign. 
 * v1.3.2: Fixed issue where negative ammo caused by bad ammo can make reload happen forever.
 * 		   You can no longer pick up ammo powerups/debuffs when reloading
 *
 * v1.4-pre1: Aliens will now shoot homing projectiles at random.
 * v1.4-pre2: Collision box now fits the rocket better. 
 * v1.4-pre3: Powerups now destroy alien projectiles. Speed change disabled for the time being. 
 * 			  DEBUG: Hitboxes can be shown by uncommenting lines.
 * v1.4-pre4: Ammunitions amount is in the form of a bar. 
 * v1.4: You can now destroy alien projectiles using rocket projectiles (ugh). Powerups now fill ammo bar and stop reloading. Bammo is much faster now.
 * v1.4.1: DEBUG: You can now toggle hitboxes using the H key. 	 
 * 
 * v1.4.2: Welcome to the final version of the v1 branch! From now on, versions will be contributing to the v2 branch.
 * For this final update of v1, we added "Alien Cohorts." They are 15 dia-aliens which appear randomly between y 0-200 (the top of the screen.)
 * They emit red particles which (as of now) do nothing. 
 * 
 * v1.4.3: A hotfix for an out-of-bounds error caused by red particles.
 * v1.4.4: Red particles shoot out in a shape of a circle (using trigonometry!)
 * ---------------------------------------------------------------------------------------
 */

/*	VERSION 2 PATCH NOTES
 * 
 *  v1.4.5-pre1: Version 2.0 Experiment Toggle can be activated using E.
 *  v1.4.5: Red Particles are now bammo
 *  
 *  v2.0 Experiment 1: Alien boss has been added (with minimal functionality)
 *  v2.0 Experiment 2: Alien boss has collision detection and a health bar. 
 *  v1.4.6: Alien Cohort Particle Patch
 * 
 * ---------------------------------------------------------------------------------------
*/

/*
 *  THINGS TO BE DONE: 
 * 
 * -Add indestructable alien
 * -Add Menus for different difficulties
 * -Add a leaderboard of highscores with initials
 * -Add different bullets: buckshot, shrapnel
 * -Add explosion animation
 * 
 * --------------------------------------------------------------------------------------
 */
