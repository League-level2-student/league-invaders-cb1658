import java.awt.Color;
import java.awt.Graphics;

public class BadAmmo extends Ammo{

	public BadAmmo(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		g.setColor(new Color(240,50,50));
		g.fillRect(x,y,width,height);
		
		if(width == 26 && height == 26) {
			g.drawLine(x+13, y+2, x+13, y+24);
			g.setColor(new Color(255,150,150));
			
			g.fillRect(x+2, y+11, width-4, 4);
		}
	}

}
