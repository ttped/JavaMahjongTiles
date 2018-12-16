import	java.awt.*;
import	java.awt.event.*;
import	java.util.*;
import	javax.swing.*;




public class Board extends JFrame {
	Tile[][][] tiles = new Tile[12][8][5];
	
	
	private	GridBagLayout		layout = new GridBagLayout();
	private	GridBagConstraints	constraints = new GridBagConstraints();
	private	JPanel			tilePanel = new JPanel(layout);
	
	
	void positionTile(Tile t, int x, int y, int z)
	{
		// Give Tile constructor the coordinates it sits on the board
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();   
		Random randomGenerator = new Random();
		while (numbers.size() < 10) {

		    int random = randomGenerator .nextInt(10);
		    if (!numbers.contains(random)) {
		        numbers.add(random);
		    }
		}
		System.out.println(numbers);
		System.out.println(numbers.get(1));

	}

}
