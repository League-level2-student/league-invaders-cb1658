import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject{

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	public boolean isMovingUp = false;
	public boolean isMovingDown = false;
	public boolean isMovingLeft = false;
	public boolean isMovingRight = false;
	
	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed = 1;
		
		if(needImage) {
			loadImage("Photoshop_rocket.png");
		}
	}

	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	public void update() {
		if(isMovingUp) {
			up();
		}
		if(isMovingDown) {
			down();
		}
		if(isMovingLeft) {
			left();
		}
		if(isMovingRight) {
			right();
		}
	}

	public void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
	
	public void up() {
		this.y -= this.speed;
	}
	
	public void down() {
		this.y += this.speed;
	}
	
	public void left() {
		this.x-= this.speed;
	}
	
	public void right() {
		this.x += this.speed;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
	public int getSpeed() {
		return this.speed;
	}
	public boolean getActive() {
		return this.isActive;
	}
	
	public boolean getUp() {
		return this.isMovingUp;
	}
	public boolean getDown() {
		return this.isMovingDown;
	}
	public boolean getLeft() {
		return this.isMovingLeft;
	}
	public boolean getRight() {
		return this.isMovingRight;
	}
	
	public void setUp(boolean b) {
		this.isMovingUp = b; 
	}
	public void setDown(boolean b) {
		this.isMovingDown = b; 
	}
	public void setLeft(boolean b) {
		this.isMovingLeft = b; 
	}
	public void setRight(boolean b) {
		this.isMovingRight = b; 
	}
}
