import java.awt.Color;
import java.awt.Graphics;

public class Circle {
	private int diameter;
	private int x;
	private int y;
	private Color color;

	public Circle( int xVal, int yVal, Color color, int d) {
		this.x = xVal;
		this.y = yVal;
		this.color = color;
		this.diameter = d;
		
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, diameter , diameter);
		g.setColor(Color.WHITE);
		g.drawLine((int) (x+(diameter/2)+((diameter/2)*.7)), (int) (y+(diameter/2)-((diameter/2)*.7)), (int) (x+(diameter/2)-((diameter/2)*.7)), (int) (y+(diameter/2)+((diameter/2)*.7)));
		g.drawLine((int) (x+(diameter/2)-((diameter/2)*.7)), (int) (y+(diameter/2)-((diameter/2)*.7)), (int) (x+(diameter/2)+((diameter/2)*.7)), (int) (y+(diameter/2)+((diameter/2)*.7)));
		
	}

}
