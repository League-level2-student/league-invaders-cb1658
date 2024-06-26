import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	
	boolean speedCalibrated = false;
	
	int currentState = 0;
	
	Timer frameDraw;
	
	Font tf = new Font("Impact", Font.PLAIN, 100);
	Font of = new Font("Impact", Font.PLAIN, 40);
	
	Rocketship rocket = new Rocketship(250,700,80,80);
	
	
	ObjectManager om = new ObjectManager(rocket,this);
	
	boolean experimentalToggle = false;
	
	public GamePanel() {
		frameDraw = new Timer(20, this); // CHANGED FROM om.getSpeed() --> 20
		frameDraw.start();
	}
	
	public Timer getFrameDraw() {
		return this.frameDraw;
	}
	
	@Override
	public void paintComponent(Graphics g){
		switch(currentState) {
		
		case MENU:
			drawMenuState(g);
			break;
		case GAME:
			drawGameState(g);
			break;
		case END:
			drawEndState(g);
			break;
		}
	}
	
	
	public void updateMenuState() {
		om.setScore();
		rocket.setActivity(true);
		om.gone();
		om.setP(2);
		om.setAmmunition(100);
		
		om.resetReload();
		
		
		
		/* if(!speedCalibrated) {
			
			frameDraw.setDelay(25);
			frameDraw.restart();
			
			speedCalibrated = true;
			
			
		} */  // SPEED CHANGER
	}
	
	public void updateGameState() {
		om.update();
		
		if(!rocket.getActive()) {
			currentState = END;
		}
	}
	
	public void updateEndState() {
		speedCalibrated = false; 
	}
	
	public void setDelay(int delay) {
		
		frameDraw = new Timer(delay, this);
		
		frameDraw.restart();

	}
	
	public boolean isExperimental() {
		return experimentalToggle;
	}
	
	public void drawMenuState(Graphics g) {
		
		if(!experimentalToggle) {
			g.setColor(new Color(0, 255, 145));
		}
		else {
			g.setColor(new Color(0, 235, 255));
		}
		
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(tf);
		g.setColor(Color.BLUE);
		
		if(experimentalToggle) {
			g.drawString("BETTER INVADERS", 200, 100);
			g.drawString("EXPERIMENTAL VERSION", 50,200);
		}
		else{
			g.drawString("BETTER INVADERS", 200, 100);
		}
		
		g.setFont(of);
		g.drawString("Press ENTER to start!", 380, 500);
		g.drawString("Press SPACE if you need help!", 310, 600);
	}

	public void drawGameState(Graphics g) {

		g.setColor(new Color(8, 1, 55));
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		om.draw(g);
		
	}
	
	public void drawEndState(Graphics g) {
		g.setColor(new Color(200, 0, 0));
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(tf);
		g.setColor(Color.BLUE);
		g.drawString("huh??? you lost!", 160,100);
		g.setFont(of);
		g.drawString("Press ENTER to redeem yourself!", 250,500);
		g.drawString("Press SPACE if you want me to System.exit(-1)", 150, 600);
		g.setFont(tf);
		g.drawString("Score: "+om.getScore(), 320, 300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(currentState) {
		case MENU:
			updateMenuState();
			break;
		case GAME:
			
			updateGameState();
			
			break;
		case END:
			//rocket = new Rocketship(250,700,80,80);
			
			rocket.setActivity(true);
			rocket.setX(250);
			rocket.setY(700);
			
			updateEndState();
			break;
		}
		
		repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			switch(currentState) {
			case MENU:
				om.startGame();
				
				currentState++;
				
				om.setShoot(false);
				break;
			case END:
				currentState = MENU;
				break;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE && currentState == 0) {
			JOptionPane.showMessageDialog(null, "As the creator of BETTER INVADERS I must inform you not to die.");
			JOptionPane.showMessageDialog(null, "ARROW KEYS are used to move the rocket around.");
			JOptionPane.showMessageDialog(null, "The space bar is used to shoot.");
			JOptionPane.showMessageDialog(null, "Press R in order to reload.");
			JOptionPane.showMessageDialog(null, "Press SHIFT to launch a powerup.");
			JOptionPane.showMessageDialog(null, "If you hate this game, press Q. Ugh why do I even have to say this.");
			JOptionPane.showMessageDialog(null, "That's it! Have fun...");
		}
		
		if(e.getKeyCode() == KeyEvent.VK_E && currentState == 0) {
			experimentalToggle = !experimentalToggle;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE && currentState == 2) {
			System.exit(-1);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_Q) {
			System.exit(-1);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			
			/*if(rocket.getY() >= rocket.getSpeed()) {
				rocket.up();
			}*/
			rocket.setUp(true);
			
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			
//			if(rocket.getY() <= LeagueInvaders.HEIGHT-2*rocket.getHeight()) {
//				rocket.down();
//			}
			rocket.setDown(true);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			
//			if(rocket.getX() >= rocket.getSpeed()) {
//				rocket.left();
//			}
			rocket.setLeft(true);
			
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
//			if(rocket.getX() <= LeagueInvaders.WIDTH-2*rocket.getWidth()) {
//				rocket.right();
//			}
			rocket.setRight(true);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE && currentState == GAME) {
			
			om.setShoot(true);
			
		}
		
		if(e.getKeyCode()== KeyEvent.VK_H && currentState == GAME) {
			
			if(!om.getBoxBool()) {
				om.setBoxBool(true);
			}
			else {
				om.setBoxBool(false);
			}
			
		}
		
		
		if(e.getKeyCode() == KeyEvent.VK_R && currentState == GAME && om.getAmmunition() != 100) {
			om.reload();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SHIFT && currentState == GAME && om.getP() > 0) {
			
			om.addPU(new Powerup(0,LeagueInvaders.HEIGHT,1000,1000));
			
			om.setP(om.getP()-1);
			
			om.setAmmunition(100);
			
			om.resetReload();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			
			rocket.setUp(false);
			
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			
			rocket.setDown(false);
			
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
	
			rocket.setLeft(false);
	
		
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
	
			rocket.setRight(false);
	
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE && currentState == GAME) {
			
			om.setShoot(false);
			
		}
		
	}
	
	public Timer getTimer() {
		return this.frameDraw;
	}
}
