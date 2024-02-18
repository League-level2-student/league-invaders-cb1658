import java.util.Random;

public class DiagonalAlien extends Alien{

	int speedX;
	
	public DiagonalAlien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		
		boolean whoKnows = new Random().nextInt(1, 101) <= 50;
		
		int left_or_right;
		
		if(whoKnows) {
			left_or_right = 1;
		}
		else {
			left_or_right = -1;
		}
		
		speedX = new Random().nextInt(5)*left_or_right;
	}
	
	
	public void update() {
		y += speed;
		x += speedX;
		collisionBox.setBounds(x, y, width, height);
		
		if(x + speedX > (LeagueInvaders.WIDTH-80) ||
				x + speedX < 0) {
			speedX = -speedX;
		}
	}
	public int getSpeedX() {
		return this.speedX;
	}
}
