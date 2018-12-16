import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CharacterTile extends Tile{
	protected char symbol;
	
	public CharacterTile(char symbol) {
		this.symbol = symbol;
		setToolTipText(toString());
	}
	
	public boolean matches(Tile other) {
		if (this == other) {
			return true;
		}
		if (other == null) {
			return false;
		}
		
		if (this.getClass() != other.getClass()) {
			return false;
		}
		
		CharacterTile a = (CharacterTile) other;
		
		return (super.matches(other) && this.symbol == a.symbol);
	}
	
	public String toString() {
		String retVal = "";
		if (this.symbol =='N') {
			retVal = "North Wind";
		}
		else if (this.symbol =='E') {
			retVal = "East Wind";
		}
		else if (this.symbol =='W') {
			retVal = "West Wind";
		}
		else if (this.symbol =='S') {
			retVal = "South Wind";
		}
		else if (this.symbol =='C') {
			retVal = "Red Dragon";
		}
		else if (this.symbol =='F') {
			retVal = "Green Dragon";
		}
		else {
			retVal = "Character " + this.symbol;
		}
			
		
		return retVal;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.red);
		
		FontMetrics fm = g.getFontMetrics();
		int wid = fm.stringWidth(String.valueOf(this.symbol));
		
		//Symbols 1-9 etc
		g.drawString(Character.toString(symbol), getWidth()-(getWidth()/8)-20-wid/2, (getHeight()/8)+20);
		
		
		
		char [] charArray = {'\u4E00', '\u4E8C', '\u4E09', '\u56DB' , '\u4E94', '\u516D', '\u4E03', '\u516B', '\u4E5D'};
		if(symbol == '1' || symbol == '2' || symbol == '3' 
				|| symbol == '4' ||symbol == '5' ||symbol == '6' 
				||symbol == '7' ||symbol == '8' ||symbol == '9' ) {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
			fm = g.getFontMetrics();
			wid = fm.stringWidth(String.valueOf(this.symbol));
			g.drawString(Character.toString('\u842C'), (getWidth() - 20)/2 -5- wid/2, getHeight()-3-fm.getHeight()/5);
			g.setColor(Color.black);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
			
			g.drawString(Character.toString(charArray[Character.getNumericValue(this.symbol)-1]), ((getWidth() - 20)/2)-5 - wid/2, (getHeight()-fm.getHeight()-5));
			
		}
		else {
			g.setColor(Color.black);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 70));
			fm = g.getFontMetrics();
			wid = fm.stringWidth(String.valueOf(this.symbol));
		}
		
		if (this.symbol =='N') {
			g.drawString(Character.toString('\u5317'), (getWidth()-20-wid)/2, getHeight()-25);
			
		}
		else if (this.symbol =='E') {
			g.drawString(Character.toString('\u6771'), (getWidth()-25-wid)/2-5, getHeight()-25);
		}
		else if (this.symbol =='W') {
			g.drawString(Character.toString('\u897F'), (getWidth()-15-wid)/2, getHeight()-25);
		}
		else if (this.symbol =='S') {
			g.drawString(Character.toString('\u5357'),(getWidth()-30-wid)/2-5, getHeight()-25);
		}
		else if (this.symbol =='C') {
			g.setColor(Color.red);
			g.drawString(Character.toString('\u4E2D'), (getWidth()-20-wid)/2, getHeight()-25);
		}
		else if (this.symbol =='F') {
			
			g.setColor(Color.green);
			g.drawString(Character.toString('\u767C'), (getWidth()-30-wid)/2-10, getHeight()-25);
		}
		
	}
	
	public static void main(String[] args)
	{
		JFrame		frame = new JFrame();
		JPanel		tiles = new JPanel();
		JScrollPane	scroller = new JScrollPane(tiles);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Character Tiles");
		frame.add(scroller);
		//frame.setLayout(new FlowLayout());

		// Try something like this if your tiles don't fit on the screen.
		// Replace "tile width" and "tile height" with your values.
		//scroller.setPreferredSize(new Dimension(8 * 100, 40 + 100));

		tiles.add(new CharacterTile('1'));
		tiles.add(new CharacterTile('2'));
		tiles.add(new CharacterTile('3'));
		tiles.add(new CharacterTile('4'));
		tiles.add(new CharacterTile('5'));
		tiles.add(new CharacterTile('6'));
		tiles.add(new CharacterTile('7'));
		tiles.add(new CharacterTile('8'));
		tiles.add(new CharacterTile('9'));
		tiles.add(new CharacterTile('N'));
		tiles.add(new CharacterTile('E'));
		tiles.add(new CharacterTile('W'));
		tiles.add(new CharacterTile('S'));
		tiles.add(new CharacterTile('C'));
		tiles.add(new CharacterTile('F'));
		
		

		frame.pack();
		frame.setVisible(true);
	}
}	