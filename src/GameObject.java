
public class GameObject {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	protected int speed = 0;
	protected boolean isActive = true;
	
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void update() {
		
	}
}
