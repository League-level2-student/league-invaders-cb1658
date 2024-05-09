import java.awt.Color;
import java.awt.Graphics;

public class RedParticle extends GameObject{

	private int speedX;
	private int speedY;
	
	public RedParticle(int x, int y, int type) {
		super(x, y,2,2);
		// TODO Auto-generated constructor stub
		
		switch(type) {
		
		case 1: 
			speedX = 16;
			speedY = -8;
			break;
		
		case 2:
			speedX = 16;
			speedY = 0;
			break;
			
		case 3:
			speedX = 16;
			speedY = 8;
			break;
		
		case 4:
			speedX = 16;
			speedY = 16;
			break;
			
		case 5:
			speedX = 8;
			speedY = 16;
			break;
		
		case 6:
			speedX = 0;
			speedY = 16;
			break;
			
		case 7:
			speedX = -8;
			speedY = 16;
			break;
		
		case 8:
			speedX = -16;
			speedY = 16;
			break;
			
		case 9:
			speedX = -16;
			speedY = 8;
			break;
			
		case 10:
			speedX = -16;
			speedY = 0;
			break;
			
		case 11:
			speedX = -16;
			speedY = -8;
			break;
			
		case 12:
			speedX = -16;
			speedY = -16;
			break;
			
		case 13:
			speedX = -8;
			speedY = -16;
			break;
			
		case 14:
			speedX = 0;
			speedY = -16;
			break;
			
		case 15:
			speedX = 8;
			speedY = -16;
			break;
			
		case 16:        
			speedX = 16;
			speedY = -16;
		}	
		
	}
	
	public void draw(Graphics g) {
		g.setColor(new Color(255,0,0));
		g.fillOval(x, y, 7, 7);
	}
	
	public void update() {
		x += speedX;
		y += speedY;
	}
	
}
