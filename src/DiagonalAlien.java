import java.util.Random;

public class DiagonalAlien extends Alien{

	int speedX;
	
	public DiagonalAlien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		
		speedX = new Random().nextInt(5);
	}
	
	
	public void update() {
		y += speed;
		x += speedX;
		collisionBox.setBounds(x, y, width, height);
		
		if(x + speedX > LeagueInvaders.WIDTH ||
				x + speedX < 0) {
			speedX = speedX * -1;
		}
	}
	public int getSpeedX() {
		return this.speedX;
	}
}
