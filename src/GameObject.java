import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	protected Rectangle collisionBox;
	
	protected int speed = 0;
	protected boolean isActive = true;
	
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		collisionBox = new Rectangle(x,y,width,height);
		
		collisionBox.setBounds(x, y, width, height);
	}
	
	public void update() {
		
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
	public void setActivity(boolean b) {
		this.isActive = b;
	}
	public void setSpeed(int s) {
		this.speed = s;
	}
	public void drawBox(Graphics g) {
		g.setColor(Color.RED); 
		g.drawRect((int)collisionBox.getX(), (int)collisionBox.getY(), (int)collisionBox.getWidth(), (int)collisionBox.getHeight()); 
	}
}
