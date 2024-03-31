import java.awt.Color;
import java.awt.Graphics;

public class Ammo extends Alien{

	public Ammo(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		g.setColor(new Color(50,50,240));
		g.fillRect(x,y,width,height);
		
		if(width == 26 && height == 26) {
			g.drawLine(x+13, y+2, x+13, y+24);
			g.setColor(new Color(150,150,255));
			g.fillRect(x+11, y+2, 4, height-4);
			g.fillRect(x+2, y+11, width-4, 4);
		}
	}

}
