import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Star extends GameObject{

	public Star(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		width = 1;
		height = 1;
		// TODO Auto-generated constructor stub
	}
	public void draw(Graphics g) {
		g.setColor(new Color(new Random().nextInt(75)+180,new Random().nextInt(75)+180,new Random().nextInt(75)+180));
		g.fillOval(x, y, width,height);
	}
	
}
