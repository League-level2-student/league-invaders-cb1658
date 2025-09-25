import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class AlienProj extends Projectile{

	Rocketship rocket;
	
	public static BufferedImage alienProjImage;
	
	static {
		loadImage2("Alien.png");
	}
	
	boolean slowedDown = false;
	
	public AlienProj(int x, int y, int width, int height, Rocketship r) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		
		speed = 7;
		
		rocket =r;
	}
	
	static void loadImage2(String imageFile) {
	   
	        try {
	            alienProjImage = ImageIO.read(AlienProj.class.getResourceAsStream(imageFile));
	           
		   
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	       
	    
	}
	
	public void draw(Graphics g) {
	
			g.drawImage(alienProjImage, x, y, width, height, null);
			// g.setColor(Color.RED); 
			// g.drawRect((int)collisionBox.getX(), (int)collisionBox.getY(), (int)collisionBox.getWidth(), (int)collisionBox.getHeight()); 
		
	}
	public void drawBox(Graphics g) {
		g.setColor(Color.RED); 
		g.drawRect((int)collisionBox.getX(), (int)collisionBox.getY(), (int)collisionBox.getWidth(), (int)collisionBox.getHeight()); 
	}
	
	public void update() {
		
		if(y > rocket.getY()) {
			
			if(!slowedDown) {
				speed*=2;
				speed/=3;
				slowedDown = true;
			}
			y+=speed;
		}else {
			y+=speed;
		}
		
		if(x > rocket.getX()) {
			x -= 4+0.02*(x-rocket.getX());
		}
		
		if(x < rocket.getX()) {
			x +=4+0.02*(rocket.getX()-x); 
	  	}
		
		collisionBox.setBounds(x, y, width, height);
	}
	
	

}
