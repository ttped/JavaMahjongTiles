import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;

public class BambooTile extends RankTile{
	Bamboo bamboos[] = new Bamboo[9];
	
	public BambooTile(int rank) {
		super(rank);
		setToolTipText(toString());
		switch(rank){
		case 2:
			bamboos[0] = new Bamboo(48, 35, Color.BLUE);
			bamboos[1] = new Bamboo( 48, 70, GREEN);
			break;
		case 3:
			bamboos[0] = new Bamboo( 48, 35, Color.BLUE);
			bamboos[1] = new Bamboo( 35, 70, GREEN);
			bamboos[2] = new Bamboo( 63, 70, GREEN);
			break;
		case 4:
			bamboos[0] = new Bamboo( 35, 35, Color.BLUE);
			bamboos[1] = new Bamboo( 35, 70, GREEN);
			bamboos[2] = new Bamboo( 63, 35, GREEN);
			bamboos[3] = new Bamboo( 63, 70, Color.BLUE);
			break;
		case 5:
			bamboos[0] = new Bamboo( 25, 35, GREEN);
			bamboos[1] = new Bamboo( 25, 70, Color.BLUE);
			bamboos[2] = new Bamboo( 49, 50, Color.RED);
			bamboos[3] = new Bamboo( 73, 35, Color.BLUE);
			bamboos[4] = new Bamboo( 73, 70, GREEN);
			break;
		case 6:
			bamboos[0] = new Bamboo( 25, 35, GREEN);
			bamboos[1] = new Bamboo( 25, 70, Color.BLUE);
			bamboos[2] = new Bamboo( 49, 35, GREEN);
			bamboos[3] = new Bamboo( 49, 70, Color.BLUE);
			bamboos[4] = new Bamboo( 73, 35, GREEN);
			bamboos[5] = new Bamboo( 73, 70, Color.BLUE);
			break;
		case 7:
			bamboos[0] = new Bamboo( 49, 21, Color.RED);
			bamboos[1] = new Bamboo( 25, 87, GREEN);
			bamboos[2] = new Bamboo( 25, 54, Color.BLUE);
			bamboos[3] = new Bamboo( 49, 87, GREEN);
			bamboos[4] = new Bamboo( 49, 54, Color.BLUE);
			bamboos[5] = new Bamboo( 73, 87, GREEN);
			bamboos[6] = new Bamboo( 73, 54, Color.BLUE);
			break;
		case 8:
			bamboos[0] = new Bamboo( 25, 21, GREEN);
			bamboos[1] = new Bamboo( 25, 87, Color.BLUE);
			bamboos[2] = new Bamboo( 49, 21, GREEN);
			bamboos[3] = new Bamboo( 49, 87, Color.BLUE);
			bamboos[4] = new Bamboo( 73, 21, GREEN);
			bamboos[5] = new Bamboo( 73, 87, Color.BLUE);
			bamboos[6] = new Bamboo( 37, 54, Color.RED);
			bamboos[7] = new Bamboo( 61, 54, Color.RED);
			break;
		case 9:
			bamboos[0] = new Bamboo( 25, 21, Color.RED);
			bamboos[2] = new Bamboo( 49, 21, Color.BLUE);
			bamboos[4] = new Bamboo( 73, 21, GREEN);
			
			bamboos[1] = new Bamboo( 25, 54, Color.RED);
			bamboos[3] = new Bamboo( 49, 54, Color.BLUE);
			bamboos[5] = new Bamboo( 73, 54, GREEN);
			
			bamboos[6] = new Bamboo( 25, 87, Color.RED);
			bamboos[7] = new Bamboo( 49, 87, Color.BLUE);
			bamboos[8] = new Bamboo( 73, 87, GREEN);
			break;
		}
		
			
	}
	

	public String toString() {
		return "Bamboo " + this.rank;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Bamboo b : bamboos)
			if (b != null)
				b.draw(g);
		
		
	}
	
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bamboo Tiles");

		frame.add(new BambooTile(2));
		frame.add(new BambooTile(3));
		frame.add(new BambooTile(4));
		frame.add(new BambooTile(5));
		frame.add(new BambooTile(6));
		frame.add(new BambooTile(7));
		frame.add(new BambooTile(8));
		frame.add(new BambooTile(9));

		frame.pack();
		frame.setVisible(true);
	}
}