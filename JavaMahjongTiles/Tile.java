import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tile extends JPanel{
	int shift = 20;
	int [] xPoints = {0,0,100, 100, 10+100, 10};
	int [] yPoints = {0+shift,100+shift,100+shift, 0+shift, shift-10, shift-10};
	
	int [] xPoints2 = {10+100, 10+100, 100, 100};
	int [] yPoints2 = {shift-10, shift-10+100, shift+100, shift};
	
	int [] xPoints3 = {0, 20, 100+20, 100};
	int [] yPoints3 = {shift, shift-20, shift-20, shift};
	
	int [] xPoints4 = {20+100, 20+100, 100, 100};
	int [] yPoints4 = {shift-20, shift-20+100, shift+100, shift};
	
	int [] xPoints6 = {20+100, 20+100, 100+10, 100+10};
	int [] yPoints6 = {shift-20, shift-20+100, shift+100-10, shift-10};
	
	int [] xPoints5 = {10, 20, 100+20, 100+10};
	int [] yPoints5 = {shift-10, shift-20, shift-20, shift-10};
	
	protected Integer xVal = null;
	protected Integer yVal = null;
	protected Integer zVal = null;
	protected boolean isRemoved = false;
	protected boolean isHighlighted = false;
	
	public	final static Dimension	SIZE 		= new Dimension(121, 121);
	public 	final static Color 		DARKGREEN  	= new Color(0, 139, 0);
	public 	final static Color 		LIGHTGREEN 	= new Color(0, 255, 0);
	public 	final static Color		TOP			= new Color(255, 231, 186);
	public 	final static Color		TOPLIGHT	= new Color(255, 250, 240);
	public 	final static Color 		GREEN  		= new Color(0, 205, 0);
	public 	final static Color 		HIGHLIGHT  		= new Color(200, 255, 150);
	
	public Tile()
	{
		setPreferredSize(SIZE);
	}
	
	public boolean matches(Tile other) {
		if (this == other) {
			return true;
		}
		if (other == null) {
			return false;
		}
		
		return (this.getClass().equals(other.getClass()));
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D	g2 = (Graphics2D)g;
		GradientPaint grad; 
		if (this.isHighlighted == true) {
			grad = new GradientPaint(0, 120, HIGHLIGHT,
					120, 0, TOP, true);
		}
		else {
			grad = new GradientPaint(0, 120, TOPLIGHT,
					120, 0, TOP, true);
		}
		g2.setPaint(grad);
		
		
		g.fillPolygon(xPoints, yPoints, 6);
		g.fillPolygon(xPoints2, yPoints2, 4);
		
		grad = new GradientPaint(0, 70, LIGHTGREEN,
				70, 0, DARKGREEN, true);
		g2.setPaint(grad);
		g.fillPolygon(xPoints5, yPoints5, 4);
		g.fillPolygon(xPoints6, yPoints6, 4);
		g.setColor(Color.black);
		g.drawPolygon(xPoints4, yPoints4, 4);
		g.drawPolygon(xPoints3, yPoints3, 4);
		g.drawRect(0, 20, 100, 100);
		
		
		
		
	}
	
	protected void place(int parentWidth, int parentHeight) {
		//System.out.println(this.xVal + " " + this.yVal + " " + this.zVal);
		
		int x = (xVal * 100 - zVal * 80) -150+ parentWidth/2;
		int y = (yVal * 100 - zVal * 120) +75 + parentHeight/2;
		if(this.zVal == 0) {
			setLocation(x-50, y-50);
			return;
		}
		else if ( this.xVal == 10 || this.xVal == 11) {
			setLocation(x, y+50);
			return;
		}
		else if ( this.xVal == -3) {
			setLocation(x, y-50);
			return;
		}
		setLocation(x, y);
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();
		//frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tile");

		frame.add(new Tile());

		frame.pack();
		frame.setVisible(true);
	}
}
