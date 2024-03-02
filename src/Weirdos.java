import java.util.Random;

public class Weirdos extends Alien{

	public Weirdos(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub

	}
	
	public void update() {
		x += new Random().nextInt(30)-15;
		y += new Random().nextInt(9);
		collisionBox.setBounds(x, y, width, height);
		
		if(x < 0) {
			x += 10;
		}
		if(x > LeagueInvaders.WIDTH) {
			x -= 10;
		}
	}

}
