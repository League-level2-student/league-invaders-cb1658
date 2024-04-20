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
	
	public void update() {
		y+=speed;
		collisionBox.setBounds(x, y, width, height);
		//super.update();
		
		if(x > rocket.getX()) {
			x -= 1;
		}
		
		if(x < rocket.getX()) {
			x +=1;
		}
	}
	
	

}
