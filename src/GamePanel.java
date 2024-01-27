import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	
	int currentState = MENU;
	
	Font tf = new Font("Impact", Font.BOLD, 70);
	
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
		
	}
	
	public void updateEndState() {
		
	}
	
	public void drawMenuState(Graphics g) {
		g.setColor(new Color(0, 255, 145));
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(tf);
		g.setColor(Color.RED);
		g.drawString("ding", 200, 200);
	}

	public void drawGameState(Graphics g) {
		g.setColor(new Color(8, 1, 71));
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}
	
	public void drawEndState(Graphics g) {
		g.setColor(new Color(189, 0, 0));
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}
}
