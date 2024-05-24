import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class RedParticle extends GameObject{

	private double speedX;
	private double speedY;
	
	public RedParticle(int x, int y, int type) {
		super(x, y,26,26);
		// TODO Auto-generated constructor stub
		
		switch(type) {
		
		case 1: 
			speedX = 16*Math.cos(Math.toRadians(22.5));
			speedY = 16*Math.sin(Math.toRadians(22.5));
			break;
		
		case 2:
			speedX = 16;
			speedY = 0;
			break;
			
		case 3:
			speedX = 16*Math.cos(Math.toRadians(337.5));
			speedY = 16*Math.sin(Math.toRadians(337.5));
			break;
		
		case 4:
			speedX = 16*Math.cos(Math.toRadians(315));
			speedY = 16*Math.sin(Math.toRadians(315));
			break;
			
		case 5:
			speedX = 16*Math.cos(Math.toRadians(292.5));
			speedY = 16*Math.sin(Math.toRadians(292.5));
			break;
		
		case 6:
			speedX = 0;
			speedY = 16;
			break;
			
		case 7:
			speedX = 16*Math.cos(Math.toRadians(247.5));
			speedY = 16*Math.sin(Math.toRadians(247.5));
			break;
		
		case 8:
			speedX = 16*Math.cos(Math.toRadians(225));
			speedY = 16*Math.sin(Math.toRadians(225));
			break;
			
		case 9:
			speedX = 16*Math.cos(Math.toRadians(202.5));
			speedY = 16*Math.sin(Math.toRadians(202.5));
			break;
			
		case 10:
			speedX = -16;
			speedY = 0;
			break;
			
		case 11:
			speedX = 16*Math.cos(Math.toRadians(157.5));
			speedY = 16*Math.sin(Math.toRadians(157.5));
			break;
			
		case 12:
			speedX = 16*Math.cos(Math.toRadians(135));
			speedY = 16*Math.sin(Math.toRadians(135));
			break;
			
		case 13:
			speedX = 16*Math.cos(Math.toRadians(112.5));
			speedY = 16*Math.sin(Math.toRadians(112.5));
			break;
			
		case 14:
			speedX = 0;
			speedY = -16;
			break;
			
		case 15:
			speedX = 16*Math.cos(Math.toRadians(67.5));
			speedY = 16*Math.sin(Math.toRadians(67.5));
			break;
			
		case 16:        
			speedX = 16*Math.cos(Math.toRadians(45));
			speedY = 16*Math.sin(Math.toRadians(45));
			break;
		}	
	}
	
	public void draw(Graphics g) {
		g.setColor(new Color(240,50,50));
		g.fillRect(x,y,width,height);
		
		g.drawLine(x+13, y+2, x+13, y+24);
		g.setColor(new Color(255,150,150));
		
		g.fillRect(x+2, y+11, width-4, 4);
	}
	
	public void update() {
		x += speedX;
		y += speedY;
		
		collisionBox = new Rectangle(x,y,width,height);
	}
	
	public Rectangle getBox() {
		return collisionBox;
	}
	
}
