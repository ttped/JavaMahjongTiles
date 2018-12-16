import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;

public class CircleTile extends RankTile{
	final Circle circles[] = new Circle[9];
	private int diameter = 70;

	public CircleTile(int rank) {
		super(rank);
		setToolTipText(toString());
		switch(rank){
		case 1:
			//circles[0] = new Circle( 50-35, 60-25, Color.RED, diameter/1);
			circles[0] = new Pancake( 50-15, 70-15, Color.RED);
			break;
		case 2:
			circles[0] = new Circle(50 -17 , 60 - 35, GREEN, (int) (diameter/1.8));
			circles[1] = new Circle(50 -17 , 60 + 15, Color.RED, (int) (diameter/1.8));
			break;
		case 3:
			circles[0] = new Circle(50 -13-26, 60-30, Color.BLUE, (int) (diameter/2.6));
			circles[1] = new Circle(50 -13, 60, Color.RED, (int) (diameter/2.6));
			circles[2] = new Circle(50 -13+26, 60+30, GREEN, (int) (diameter/2.6));
			break;
		case 4:
			circles[0] = new Circle(36 - 12, 60 - 21, Color.BLUE, (int) (diameter/2.5));
			circles[1] = new Circle(36 - 12, 60 + 9, GREEN, (int) (diameter/2.5));
			circles[2] = new Circle(36 + 18, 60 - 21, GREEN, (int) (diameter/2.5));
			circles[3] = new Circle(36 + 18, 60+ 9, Color.BLUE, (int) (diameter/2.5));
			break;
		case 5:
			circles[0] = new Circle(50-33, 60+22, Color.BLUE, (int) (diameter/2.5)); 
			circles[1] = new Circle(50+11, 60-22, Color.BLUE, (int) (diameter/2.5));
			circles[2] = new Circle(50-11, 60, Color.RED, (int) (diameter/2.5));
			circles[3] = new Circle(50+11, 60+22, GREEN, (int) (diameter/2.5));
			circles[4] = new Circle(50-33, 60-22, GREEN, (int) (diameter/2.5));
			break;
		case 6:
			circles[0] = new Circle(50 - 28, 60-30, GREEN, (int) (diameter/2.5));
			circles[1] = new Circle(50 + 3, 60-30, GREEN, (int) (diameter/2.5));
			circles[2] = new Circle(50 - 28, 60, Color.RED, (int) (diameter/2.5));
			circles[3] = new Circle(50 + 3, 60, Color.RED, (int) (diameter/2.5));
			circles[4] = new Circle(50 - 28, 60+30, Color.RED, (int) (diameter/2.5));
			circles[5] = new Circle(50 + 3, 60+30, Color.RED, (int) (diameter/2.5)); 
			break;
		case 7:
			circles[0] = new Circle(25-9, 60-35, GREEN, (int) (diameter/3.8));
			circles[1] = new Circle(50-9, 60-25, GREEN, (int) (diameter/3.8));
			circles[2] = new Circle(75-9, 60-15, GREEN, (int) (diameter/3.8));
			circles[3] = new Circle(37-9, 60+5, Color.RED, (int) (diameter/3.8));
			circles[4] = new Circle(62-9, 60+5, Color.RED, (int) (diameter/3.8));
			circles[5] = new Circle(37-9, 60+30, Color.RED, (int) (diameter/3.8));
			circles[6] = new Circle(62-9, 60+30, Color.RED, (int) (diameter/3.8));
			break;
		case 8:
			circles[0] = new Circle(50 - 20, 60-7, Color.BLUE, diameter/5); 
			
			circles[2] = new Circle(50 - 20, 60-31, Color.BLUE, diameter/5);
			
			circles[4] = new Circle(50 - 20, 60+17, Color.BLUE, diameter/5);
			circles[7] = new Circle(50 - 20, 60+41, Color.BLUE, diameter/5);
			
			circles[3] = new Circle(50 + 10, 60-7, Color.BLUE, diameter/5);
			circles[1] = new Circle(50 + 10, 60-31, Color.BLUE, diameter/5);
			circles[5] = new Circle(50 + 10, 60+17, Color.BLUE, diameter/5);
			circles[6] = new Circle(50 + 10, 60+41, Color.BLUE, diameter/5);
			
			break;
		case 9:
			circles[0] = new Circle(20, 30, GREEN, diameter/5);
			circles[1] = new Circle(44, 30, GREEN, diameter/5);
			circles[2] = new Circle(67, 30, GREEN, diameter/5);
			circles[3] = new Circle(20, 60, Color.RED, diameter/5);
			circles[4] = new Circle(44, 60, Color.RED, diameter/5);
			circles[5] = new Circle(67, 60, Color.RED, diameter/5);
			circles[6] = new Circle(20, 90, Color.BLUE, diameter/5);
			circles[7] = new Circle(44, 90, Color.BLUE, diameter/5);
			circles[8] = new Circle(67, 90, Color.BLUE, diameter/5);
			break;
		}
		
	}
	
	public String toString() {
		return "Circle " + this.rank;
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Circle c : circles)
			if (c != null)
				c.draw(g);
		
		
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Circle Tiles");

		frame.add(new CircleTile(1));
		frame.add(new CircleTile(2));
		frame.add(new CircleTile(3));
		frame.add(new CircleTile(4));
		frame.add(new CircleTile(5));
		frame.add(new CircleTile(6));
		frame.add(new CircleTile(7));
		frame.add(new CircleTile(8));
		frame.add(new CircleTile(9));

		frame.pack();
		frame.setVisible(true);
	}
}