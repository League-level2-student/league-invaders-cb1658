
public class Boss extends Alien{

	private int health = 100;
	
	public Boss() {
		super(125, -500, 800, 500);
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		
		if(y < -100) {
			y+=4;
		}
		else {
			y += 0.5;
		}
	}

	public int getHealth() {
		return health;
	}
	
	public void setHealth(int i) {
		health = i;
	}
	
}
