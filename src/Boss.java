import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Boss extends Alien{

	private int health = 1000;
	
	public Boss() {
		super(0, -700, 1000, 625);
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		
		if(y < -100) {
			y+=3;
		}
		
		collisionBox = new Rectangle(x,y,width,height);
	}

	public void draw(Graphics g) {
		super.draw(g);
		
		if(health >= 500) {
			g.setColor(new Color((int)((double)255/(double)500*(1000-health)) , 255, 0));
		}
		else {
			g.setColor(new Color(255, (int)(255 - (double)255/(double)500*(500-health)), 0));
		}
		
		g.drawRect(0, y+650, 1000, 30);
		g.fillRect(0, y+650, health, 30);
	}
	
	public int getHealth() {
		return health;
	}
	
	public void takeDamage() {
		health -= 10;
	}
	
	public void powerupDamage() {
		health -= 500;
	}
	
	
	
}
