import java.util.Random;

public class Powerup extends Projectile{

	public Powerup(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		this.speed = new Random().nextInt(50)+1;
	}

}
