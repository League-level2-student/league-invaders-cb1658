import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed = 10;
	}

	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
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
}
