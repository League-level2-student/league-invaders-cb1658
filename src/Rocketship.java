import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
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
		this.speed = 6;
		collisionBox = new Rectangle(x,y,width,height);
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
	
	public Projectile getProjectile() {
        return new Projectile(x+width/2, y, 10, 10);
	}
	public Rectangle getBox() {
		return this.collisionBox;
	}
	
	public void update() {
		if(isMovingUp && getY() >= getSpeed()) {
			up();
		}
		if(isMovingDown && getY() <= LeagueInvaders.HEIGHT-getHeight()) {
			down();
		}
		if(isMovingLeft && getX() >= getSpeed()) {
			left();
		}
		if(isMovingRight && getX() <= LeagueInvaders.WIDTH-getWidth()) {
			right();
		}
		collisionBox.setBounds(x + width/4, y, width - width/2, height);
	}

	public void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
//			g.drawRect((int)collisionBox.getX(), (int)collisionBox.getY(), (int)collisionBox.getWidth(), (int)collisionBox.getHeight());
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
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y=y;
	}
}
