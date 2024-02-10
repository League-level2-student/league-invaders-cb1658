import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	
	
	
	int currentState = 0;
	
	Timer frameDraw;
	
	Font tf = new Font("Impact", Font.PLAIN, 100);
	Font of = new Font("Impact", Font.PLAIN, 40);
	
	Rocketship rocket = new Rocketship(250,700,50,50);
	
	
	
	ObjectManager om = new ObjectManager(rocket);
	
	public GamePanel() {
		frameDraw = new Timer(1000/500, this);
		frameDraw.start();
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
		
	}
	
	public void updateGameState() {
		om.update();
	}
	
	public void updateEndState() {
		
	}
	
	public void drawMenuState(Graphics g) {
		g.setColor(new Color(0, 255, 145));
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(tf);
		g.setColor(Color.BLUE);
		g.drawString("BETTER INVADERS", 200, 100);
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
				currentState++;
				break;
			case END:
				currentState = MENU;
				break;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE && currentState == 0) {
			JOptionPane.showMessageDialog(null, "As the creator of BETTER INVADERS I must inform you not to die.");
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE && currentState == 2) {
			System.exit(-1);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			
			if(rocket.getY() >= rocket.getSpeed()) {
				rocket.up();
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			
			if(rocket.getY() <= LeagueInvaders.HEIGHT-2*rocket.getHeight()) {
				rocket.down();
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			
			if(rocket.getX() >= rocket.getSpeed()) {
				rocket.left();
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			if(rocket.getX() <= LeagueInvaders.WIDTH-2*rocket.getWidth()) {
				rocket.right();
			}
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
