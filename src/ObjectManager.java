import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	
	public ObjectManager(Rocketship r) {
		addAlien();
		addProjectile(new Projectile(100,100,20,30));
		this.rocket = r;
	}
	
	public void addProjectile(Projectile p) {
		projectiles.add(p);
	}
	public void addAlien() {
		aliens.add(new Alien(new Random().nextInt(LeagueInvaders.WIDTH),0,80,50));
	}
	public void update() {
		for(int i = 0; i<aliens.size(); i++) {
			aliens.get(i).update();
			
			if(aliens.get(i).getY() > LeagueInvaders.HEIGHT) {
				aliens.get(i).setActivity(false);
			}
		}
		for(int i = 0; i<projectiles.size(); i++) {
			projectiles.get(i).update();
			
			if(projectiles.get(i).getY() > LeagueInvaders.HEIGHT) {
				projectiles.get(i).setActivity(false);
			}
		}
	}
	
	public void draw(Graphics g) {
		rocket.draw(g);
		for(int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for(int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}
	
	public void purgeObjects() {
		for(int i = aliens.size()-1; i >= 0; i--) {
			if(aliens.get(i).getActive() == false) {
				aliens.remove(i);
			}
		}
		for(int i = projectiles.size()-1; i >= 0; i--) {
			if(projectiles.get(i).getActive() == false) {
				projectiles.remove(i);
			}
		}
	}
}
