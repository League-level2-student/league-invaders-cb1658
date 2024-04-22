import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

public class ObjectManager implements ActionListener{
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	ArrayList<DiagonalAlien> diaaliens = new ArrayList<>();
	ArrayList<Star> stars = new ArrayList<Star>();
	ArrayList<Weirdos> w = new ArrayList<Weirdos>();
	
	ArrayList<Powerup> pu = new ArrayList<Powerup>();
	
	ArrayList<Ammo> am = new ArrayList<Ammo>();
	
	ArrayList<BadAmmo> bam = new ArrayList<BadAmmo>();
	
	ArrayList<AlienProj> ap = new ArrayList<AlienProj>();
	
	Random rand = new Random ();
	
	Timer reloadTimer = new Timer(5000,this);
	
	boolean reloadTimerStarted = false;
	
	int powerupsLeft = 2;
	
	int ammunitionLeft = 200;
	
	int gameSpeed = 25;
	
	boolean gameSpeedAlreadyIncreased = false;
	
	int score = 0;
	
	Timer alienSpawn = new Timer(1000, this);
	
	Timer shoottimer = new Timer(1000/15, this);
	
	GamePanel gp;
	
	boolean isDrawingBox = false;
	
	boolean isRocketShooting = false;
	
	public ObjectManager(Rocketship r, GamePanel gamePanel) {
		for(int i = 0; i < 200; i++) {
			addStar();
		}
		
		this.gp = gamePanel;
		
		this.rocket = r;
		shoottimer.start();
	}
	public void addStar() {
		stars.add(new Star(new Random().nextInt(1000), new Random().nextInt(1000), 5, 5));
	}
	
	public int getAmmunition() {
		return this.ammunitionLeft;
	}
	
	public void setAmmunition(int u) {
		this.ammunitionLeft = u;
	}
	
	public void startGame() {
		
		gameSpeed = 25;
		
		alienSpawn.start();
	}
	
	public boolean ohShoot() {
		return this.isRocketShooting;
	}
	
	public void setShoot(boolean b) {
		isRocketShooting = b;
	}   
	
	public int getP() {
		return this.powerupsLeft;
	}
	
	public void setP(int i) {
		this.powerupsLeft = i;
	}
	
	public void reload() {
		reloadTimer.setRepeats(false);
		reloadTimer.start();
		
		reloadTimerStarted=true;
	}
	
	public boolean isReloading() {
		return reloadTimer.isRunning();
	}
	
	
	public void setGameSpeed(int x) {
		gameSpeed = x;
		
		gp.setDelay(x);
	}
	
	public int getSpeed() {
		return this.gameSpeed;
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
	
	public void addAP(int x, int y) {
		ap.add(new AlienProj(x,y,32,20,rocket));
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
		
		for(int i = 0; i < pu.size(); i++) {
			pu.get(i).update();
			
			if(pu.get(i).getY() > LeagueInvaders.HEIGHT) {
				pu.get(i).setActivity(false);
			}
		}
		
		for(int i = 0; i < am.size(); i++) {
			am.get(i).update();
			
			if(am.get(i).getY() > LeagueInvaders.HEIGHT) {
				am.get(i).setActivity(false);
			}
		}
		
		for(int i = 0; i < bam.size(); i++) {
			bam.get(i).update();
			
			if(bam.get(i).getY() > LeagueInvaders.HEIGHT) {
				bam.get(i).setActivity(false);
			}
		}
		
		for(int i = 0; i < ap.size(); i++) {
			ap.get(i).update();
			
			if(ap.get(i).getY() > LeagueInvaders.HEIGHT) {
				ap.get(i).setActivity(false);
			}
		}
		
		if(getAmmunition() <= 0 && (!reloadTimerStarted)) {
			reload();
		}
		if(!isReloading() && reloadTimerStarted) {
			setAmmunition(100);
			reloadTimerStarted = false;
		}
		
		
		/*if((score % 100 > 0 && score % 100 < 50) && !gameSpeedAlreadyIncreased && !(score < 100)) {
			setGameSpeed(getSpeed()-1);
			gameSpeedAlreadyIncreased = true;
		}*/ //SPEED CHANGER
		
		if(score % 100 > 60 && score % 100 < 90) {
			gameSpeedAlreadyIncreased = false;
		}
		
		rocket.update();
		
		checkCollision();
		purgeObjects();
	}
	
	public void addAmmo() {
		am.add(new Ammo(new Random().nextInt(LeagueInvaders.WIDTH),-50,26,26));
	}
	
	public void addBammo() {
		bam.add(new BadAmmo(new Random().nextInt(LeagueInvaders.WIDTH),-50,26,26));
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
		for(Powerup p : pu) {
			p.draw(g);
		}
		
		for(Ammo a : am) {
			a.draw(g);
		}
		
		for(Ammo b : bam) {
			b.draw(g);
		}
		
		for(AlienProj proj : ap) {
			proj.draw(g);
		}
		
		rocket.draw(g);
		
		g.setColor(Color.WHITE);
		
		g.setFont(new Font("Impact", Font.PLAIN, 40));
		g.drawString("Score: "+getScore(),25 ,50);
		
		if(getAmmunition() == 100) {
			g.setColor(new Color(150, 255,150));
		}
		
		if(getAmmunition() < 26) {
			g.setColor(Color.ORANGE);
		}
		
		if(getAmmunition() < 11) {
			g.setColor(new Color(255,100,0));
		}
		
		if(getAmmunition() <= 0 || isReloading()) {
			g.setColor(Color.RED);
			g.drawString("Ammunitions left: RELOADING", 25,100);
		}
		else {
			g.drawString("Ammunitions left: ", 25,100);
			g.drawRect(330,60,100,50);
			g.fillRect(330,60,getAmmunition(),50);
		}

		if(getP()==1) {
			g.setColor(Color.ORANGE);
		}
		else {
			g.setColor(Color.WHITE);
		}
		
		if(!(getP()==0)) {
			g.drawString("Powerups left: " + getP(), 25,150);
		}
		
		if(isDrawingBox) {
			drawBoxes(g);
		}
		
		g.setColor(Color.WHITE);
		
		g.drawString("1.4.1", 10,990);
		
	}
	
	public void resetReload() {
		this.reloadTimer.stop();
	}
	
	public void setScore() {
		score = 0;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setBoxBool(boolean b) {
		isDrawingBox = b;
	}
	public boolean getBoxBool() {
		return isDrawingBox;
	}
	
	public void drawBoxes(Graphics g) {
		for(Alien alien : aliens) {
			alien.drawBox(g);
		}
		for(Projectile proj: projectiles) {
			proj.drawBox(g);
		}
		for(DiagonalAlien diaalien : diaaliens) {
			diaalien.drawBox(g);
		}
		for(Weirdos ww : w) {
			ww.drawBox(g);
		}
		for(Powerup p : pu) {
			p.drawBox(g);
		}
		
		for(Ammo a : am) {
			a.drawBox(g);
		}
		
		for(Ammo b : bam) {
			b.drawBox(g);
		}
		
		for(AlienProj proj : ap) {
			proj.drawBox(g);
		}
		
		rocket.drawBox(g);
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
		
		
		for(Alien diaalien : aliens) {
			for(Powerup proj : pu) {
				if(proj.getBox().intersects(diaalien.getBox())) {
					diaalien.setActivity(false);
				}
			}
		}
		
		for(DiagonalAlien diaalien : diaaliens) {
			for(Powerup proj : pu) {
				if(proj.getBox().intersects(diaalien.getBox())) {
					diaalien.setActivity(false);
				}
			}
		}
		
		for(Weirdos diaalien : w) {
			for(Powerup proj : pu) {
				if(proj.getBox().intersects(diaalien.getBox())) {
					diaalien.setActivity(false);
				}
			}
		}
		
		for(Ammo a : am) {
			if(rocket.getBox().intersects(a.getBox()) && !isReloading() && ammunitionLeft != 100) {

				if(ammunitionLeft + 30 > 100) {
					ammunitionLeft = 100;
				}
				else {
					ammunitionLeft += 30;
				}
				
				a.setActivity(false);
			}
		}
		
		for(BadAmmo ba : bam) {
			if(rocket.getBox().intersects(ba.getBox()) && !isReloading()) {

				ammunitionLeft -= 30;
				
				ba.setActivity(false);
			}
		}
		
		for(AlienProj proj : ap) {
			if(rocket.getBox().intersects(proj.getBox())) {
				rocket.setActivity(false);
				proj.setActivity(false);
			}
			
			for(Powerup p : pu) {
				if(proj.getBox().intersects(p.getBox())) {
					proj.setActivity(false);
				}
			}
			
			for(Projectile ppp : projectiles) {
				if(ppp.getBox().intersects(proj.getBox())) {
					ppp.setActivity(false);
					proj.setActivity(false);
				}
			}
		}
	}
	
	
	public void addPU(Powerup p) {
		pu.add(p);
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
		
		for(int i = am.size()-1; i >= 0 ; i--) {
			if(am.get(i).getActive() == false) {
				am.remove(i);
			}
		}
		
		for(int i = bam.size()-1; i >= 0 ; i--) {
			if(bam.get(i).getActive() == false) {
				bam.remove(i);
			}
		}
		
		for(int i = ap.size()-1; i >= 0; i--) {
			if(ap.get(i).getActive() == false) {
				ap.remove(i);
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
		
		for(int i = pu.size()-1; i >= 0; i--) {
			pu.remove(i);
		}
		
		for(int i = am.size()-1; i >= 0; i--) {
			am.remove(i);
		}
		
		for(int i = bam.size()-1; i >= 0; i--) {
			bam.remove(i);
		}
		
		for(int i = ap.size()-1; i >= 0; i--) {
			ap.remove(i);
		}
	}
	
	public void alienWave1() {
		int rand_ = rand.nextInt(500);
		
		for(int i = 0; i < 10; i++) {
			addAlien(rand_+20*i);
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
	
	public void thisWaveWillEndYouForSure() {
		for(int i = 0; i < 15; i++) {
			alienWave1();
		}
		for(int i = 0; i < 10; i++) {
			alienWave2();
		}
		for(int i = 0; i < 5; i++) {
			alienWave3();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == alienSpawn) {
			addAlien();
			
			int rand_ = rand.nextInt(100);

			if(rand_ < 25) {
				alienWave1();
			}
			
			int rand2 = rand.nextInt(100);
			
			if(rand2 < 15) {
				alienWave2();
			}
			
			int rand3 = rand.nextInt(100);
			
			if(rand3 < 10) {
				alienWave3();
			}
			
			if(rand_ < 5 && rand2 < 80 && rand3 < 50) {
				thisWaveWillEndYouForSure();
			}
			
			if(rand_ < 25 && rand2 < 50 && rand3 < 75) {
				addAmmo();
			}
			
			  if(rand3 < 20) {
				addBammo();
			}
		}
		
		for(Alien a : aliens) {
			
			if(rand.nextInt(100) < 2 && rand.nextInt(100) < 25) {
				addAP(a.getX(),a.getY());
			}
			
		}
		
		
		if(e.getSource() == shoottimer) {
			if(isRocketShooting && (getAmmunition()>0) && !isReloading()) {
				
				addProjectile(new Projectile(rocket.getX()+rocket.getWidth()/2,rocket.getY()+rocket.getHeight()/2,10,10));
				setAmmunition(getAmmunition()-1);
			}
		}
		
	}
}
