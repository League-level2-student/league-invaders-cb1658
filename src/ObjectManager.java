import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	ArrayList<Star> stars = new ArrayList<Star>();
	
	int score = 0;
	
	public ObjectManager(Rocketship r) {
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
		aliens.add(new Alien(new Random().nextInt(LeagueInvaders.WIDTH),-50,80,50));
	}
	
	public void addAlien(int x) {
		aliens.add(new Alien(x,-50,80,50));
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
		
		checkCollision();
		purgeObjects();
	}
	
	public void draw(Graphics g) {
		
		for(Alien alien : aliens) {
			alien.draw(g);
		}
		for(Projectile proj: projectiles) {
			proj.draw(g);
		}
		for(Star star:stars) {
			star.draw(g);
		}
		rocket.draw(g);
		
		g.setFont(new Font("Impact", Font.PLAIN, 40));
		g.drawString("Score: "+getScore(),25 ,50);
		
	}
	public void setScore() {
		score = 0;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void checkCollision() {
		for(Alien alien : aliens) {
			for(Projectile proj : projectiles) {
				if(proj.getBox().intersects(alien.getBox())) {
					alien.setActivity(false);
					proj.setActivity(false);
					score++;
				}
			}
			if(rocket.getBox().intersects(alien.getBox())) {
				rocket.setActivity(false);
				alien.setActivity(false);
			}
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
	
	public void gone() {
		for(int i = aliens.size()-1; i >= 0; i--) {
			
				aliens.remove(i);
			
		}
		for(int i = projectiles.size()-1; i >= 0; i--) {
			
				projectiles.remove(i);
			
		}
	}
	
	public void alienWave1() {
		int rand = new Random().nextInt(500);
		
		for(int i = 0; i < 10; i++) {
			addAlien(rand+20*i);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
		
		int rand = new Random().nextInt(100);
		if(rand < 3) {
			alienWave1();
		}
	}
}
