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
	ArrayList<DiagonalAlien> diaaliens = new ArrayList<>();
	ArrayList<Star> stars = new ArrayList<Star>();
	ArrayList<Weirdos> w = new ArrayList<Weirdos>();
	
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
	public void addW() {
		w.add(new Weirdos(new Random().nextInt(LeagueInvaders.WIDTH),-50,80,50));
	}
	
	public void addAlien(int x) {
		aliens.add(new Alien(x,-50,80,50));
	}
	
	public void addDia_Alien() {
		diaaliens.add(new DiagonalAlien(new Random().nextInt(LeagueInvaders.WIDTH),-50,80,50));
	}
	
	public void addDia_Alien(int x) {
		diaaliens.add(new DiagonalAlien(x,-50,80,50));
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
		
		for(int i = 0; i < diaaliens.size(); i++) {
			diaaliens.get(i).update();
			
			if(diaaliens.get(i).getY() > LeagueInvaders.HEIGHT) {
				diaaliens.get(i).setActivity(false);
			}
		}
		for(int i = 0; i < w.size(); i++) {
			w.get(i).update();
			
			if(w.get(i).getY() > LeagueInvaders.HEIGHT) {
				w.get(i).setActivity(false);
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
		for(DiagonalAlien diaalien : diaaliens) {
			diaalien.draw(g);
		}
		for(Star star:stars) {
			star.draw(g);
		}
		for(Weirdos ww : w) {
			ww.draw(g);
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
		
		for(DiagonalAlien diaalien : diaaliens) {
			for(Projectile proj : projectiles) {
				if(proj.getBox().intersects(diaalien.getBox())) {
					diaalien.setActivity(false);
					proj.setActivity(false);
					score++;
				}
			}
			if(rocket.getBox().intersects(diaalien.getBox())) {
				rocket.setActivity(false);
				diaalien.setActivity(false);
			}
		}
		
		for(Weirdos ww : w) {
			for(Projectile proj : projectiles) {
				if(proj.getBox().intersects(ww.getBox())) {
					ww.setActivity(false);
					proj.setActivity(false);
					score++;
				}
			}
			if(rocket.getBox().intersects(ww.getBox())) {
				rocket.setActivity(false);
				ww.setActivity(false);
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
		for(int i = diaaliens.size()-1; i >= 0 ; i--) {
			if(diaaliens.get(i).getActive() == false) {
				diaaliens.remove(i);
			}
		}
		
		for(int i = w.size()-1; i >= 0 ; i--) {
			if(w.get(i).getActive() == false) {
				w.remove(i);
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
		
		for(int i = diaaliens.size()-1; i >= 0; i--) {
			diaaliens.remove(i);
		}
		
		for(int i = w.size()-1; i >= 0; i--) {
			w.remove(i);
		}
	}
	
	public void alienWave1() {
		int rand = new Random().nextInt(500);
		
		for(int i = 0; i < 10; i++) {
			addAlien(rand+20*i);
		}
	}
	
	public void alienWave2() {
		for(int i = 0; i < 5; i++) {
			addDia_Alien();
		}
	}
	
	public void alienWave3() {
		for(int i = 0; i < 5; i++) {
			w.add(new Weirdos(new Random().nextInt(LeagueInvaders.WIDTH-200)+40*i,-50,80,50));
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		addAlien();
		
		int rand = new Random().nextInt(100);

		if(rand < 10) {
			alienWave1();
		}
		
		int rand2 = new Random().nextInt(100);
		
		if(rand2 < 3) {
			alienWave2();
		}
		
		int rand3 = new Random().nextInt(100);
		
		if(rand3 < 2) {
			alienWave3();
		}
		
	}
}
