import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Pancake extends Circle
{

	public Pancake(int x, int y, Color c) 
	{
		super(x, y, c, 30);
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Tile.GREEN);
		g.fillOval(50-35, 70-35, 70, 70);
		g.setColor(Color.WHITE);
		super.draw(g);
		g.setColor(Color.BLACK);
		g.drawOval(50-35, 70-35, 70, 70);
		Graphics2D	g2 = (Graphics2D)g;
		g2.setColor(Color.WHITE);
		g2.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_ROUND, 
				BasicStroke.JOIN_MITER, 5.0f, new float[] {0.4f, 7.0f}, 10.0f));
		g2.drawOval(50-25, 70-25, 50, 50);
		
	}

}