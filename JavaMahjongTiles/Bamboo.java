import java.awt.Color;
import java.awt.Graphics;

public class Bamboo{
	private int x;
	private int y;
	private Color color;

	public Bamboo( int x, int y, Color c) {
		this.x = x;
		this.y = y;
		this.color = c;
	}

	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, 11, 6);
		g.fillOval(x, y+26, 11, 6);
		g.fillRoundRect(x+2, y+1, 7, 28, 2, 2);
		g.setColor(Color.WHITE);
		g.drawLine(x+6, y+5, x+6, y+27);
		g.setColor(color);
		g.fillOval(x, y+13, 11, 6);
		
	}

}
