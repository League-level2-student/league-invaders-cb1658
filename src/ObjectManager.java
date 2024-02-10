import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	ArrayList<Star> stars = new ArrayList<Star>();
	
	public ObjectManager(Rocketship r) {
		addAlien();
		addProjectile(new Projectile(100,100,15,25));
		for(int i = 0; i < 200; i++) {
			addStar();
		}
		this.rocket = r;
	}
	public void addStar() {
		stars.add(new Star(new Random().nextInt(1000), new Random().nextInt(1000), 5, 5));
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
		rocket.update();
	}
	
	public void draw(Graphics g) {
		rocket.draw(g);
		for(Alien alien : aliens) {
			alien.draw(g);
		}
		for(Projectile proj: projectiles) {
			proj.draw(g);
		}
		for(Star star:stars) {
			star.draw(g);
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
