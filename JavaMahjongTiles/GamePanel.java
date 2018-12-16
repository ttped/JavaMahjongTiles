import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GamePanel extends JPanel implements MouseListener {

	private static Random random;
	private Map<String, Tile> board = new HashMap<>();
	private String backgroundString = "images/dragon_bg.png";
	List<Tile> deckHolder = new ArrayList<>();
	Tile firstPick = null;
	private Stack<Tile> removedTiles = new Stack<>();
	private JPanel discardPanel = null;
	private JScrollPane scrollPane = null;
	
	private boolean sound = true;
	private Fireworks fireworks = null;
	
	
	public GamePanel(int width, int height, Long randomNumber) {
		
		discardPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		scrollPane = new JScrollPane(discardPanel);
		
		
		random = new Random(randomNumber);
		setSize(width, height);


		List<Tile> deck = initializeDeck();

		// Start at the top middle tile
		int xVal = 0;
		int yVal = 0;
		int zVal = 0;
		
		// Every tile gets set to the correct size, then we set the position
		// and put the tile into our board
		for (Tile tile : deck) {
			tile.setSize(121, 121);
			tile.xVal = xVal;
			tile.yVal = yVal;
			tile.zVal = zVal;
			tile.addMouseListener(this);
			

			board.put(getKey(xVal, yVal, zVal), tile);
			
			deckHolder.add(tile);

			int[] newPositions = getNewPositions(xVal, yVal, zVal);
			xVal = newPositions[0];
			yVal = newPositions[1];
			zVal = newPositions[2];
		}
		addMouseListener(this);
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (backgroundString != null) {
			ImageIcon image = new ImageIcon(getClass().getResource(backgroundString));
			int xDiff = getWidth() - image.getIconWidth();
			int yDiff = getHeight() - image.getIconHeight();
			if (xDiff < 0 || yDiff < 0) {
				int diff = xDiff - yDiff;
				image = new ImageIcon(image.getImage().getScaledInstance(diff >= 0 ? getWidth() : -1, diff < 0 ? getHeight() : -1, Image.SCALE_DEFAULT));
			}
			g.drawImage(image.getImage(), getWidth() / 7 - image.getIconWidth() / 7, getHeight() / 7 - image.getIconHeight() / 7, 1400, 800, null);
		}

		draw();
	}
	
	private void draw() {
		List<Tile> deck = new ArrayList<>();
		deck.addAll(board.values());
		for (Tile tile : deckHolder) {
			if (tile.isRemoved == true) {
				
			}
			else {
				tile.place(getWidth(), getHeight());
				add(tile);
			}
		}
	
	}


	//determines the x,y,z coordinates for the tiles
	private int[] getNewPositions(int currentxVal, int currentyVal, int currentzVal) {
		int maxX;
		int maxY;
		int xStop = 0;

		switch (currentzVal) {
			case 0:
				maxX = 0;
				maxY = 0;
				break;
			case 1:
				maxX = 1;
				maxY = 1;
				break;
			case 2:
				maxX = 3;
				maxY = 3;
				break;
			case 3:
				maxX = 5;
				maxY = 5;
				break;
			case 4:
				maxY = 7;
				switch (currentyVal) {
					case 0:
						maxX = 8; 
						xStop = -2;
					case 1:
						maxX = 7;
						break;
					case 2:
						maxX = 8;
						xStop = -1;
						break;
					case 3:
						maxX = 11;
						xStop = -2;
						break;
					case 4:
						maxX = 9;
						xStop = -3;
						break;
					case 5:
						maxX = 8;
						xStop = -1;
						break;
					case 6:
						maxX = 7;
						break;
					case 7:
						maxX = 8; 
						xStop = -2;
						break;
					default:
						maxX = 0;
				}
				break;
			default:
				maxX = 0;
				maxY = 0;
				break;
		}


		if (currentzVal == 0) {
			currentxVal = 1;
			currentyVal = 0;
			currentzVal = 1;
		}
		else if (currentzVal == 1) {
			if(currentxVal == 0 && currentyVal == maxY) {
				currentxVal = 3;
				currentyVal = 0;
				currentzVal++;
			}
			else {
				if(currentxVal == 0) {
					currentxVal = maxX;
					currentyVal++;
				}
				else {
					currentxVal--;
				}
				
			}
		}
		else if(currentzVal == 2) {
			if(currentxVal == 0 && currentyVal == maxY) {
				currentxVal = 5;
				currentyVal = 0;
				currentzVal++;
			}
			else {
				if(currentxVal == 0) {
					currentxVal = maxX;
					currentyVal++;
				}
				else {
					currentxVal--;
				}
				
			}
		
		}
		else if(currentzVal == 3) {
			if(currentxVal == 0 && currentyVal == maxY) {
				currentxVal = 9;
				currentyVal = 0;
				currentzVal++;
			}
			else {
				if(currentxVal == 0) {
					currentxVal = maxX;
					currentyVal++;
				}
				else {
					currentxVal--;
				}
				
			}
			
		}
		else if(currentzVal == 4) {
			if(currentxVal <= -2 && currentyVal == maxY) {
				
			}
			else {
				if(currentxVal == xStop) {
					currentyVal++;
					switch (currentyVal) {
					case 0:
						maxX = 9; 
						xStop = -2;
					case 1:
						maxX = 7;
						break;
					case 2:
						maxX = 8;
						xStop = -1;
						break;
					case 3:
						maxX = 11;
						xStop = -2;
						break;
					case 4:
						maxX = 9;
						xStop = -3;
						break;
					case 5:
						maxX = 8;
						xStop = -1;
						break;
					case 6:
						maxX = 7;
						break;
					case 7:
						maxX = 9; 
						xStop = -2;
						break;
					default:
						maxX = 0;
				}
					currentxVal = maxX;
					
				}
				else {
					currentxVal--;
				}
			}
		}
		int[] positions = new int[]{currentxVal, currentyVal, currentzVal};
		return positions;
	}
	
	public Tile getTile(int xVal, int yVal, int zVal) {
		return board.get(getKey(xVal, yVal, zVal));
	}
	private String getKey(int xVal, int yVal, int zVal) {
		return xVal + "_" + yVal + "_" + zVal;
	}

	

	public boolean isOpen(Tile tile) {
		if (tile == null
				|| tile.xVal == null || tile.yVal == null || tile.zVal == null) {
			System.err.println("Invalid tile to check for open.");
			return false;
		}
		int xVal = tile.xVal;
		int yVal = tile.yVal;
		int zVal = tile.zVal;
		// Special logic for evaluating 2nd row
		if(zVal == 1 && (getTile(0, 0, 0) != null)) {
			 return false;
		}
		else if(getTile(xVal-1, yVal-1, zVal-1) != null && getTile(xVal-1, yVal-1, zVal-1).isRemoved == false) {
			return false;
		}
		//Special case logic for evaluating tiles interacting with leftmost tile in between 2 tiles
		else if(xVal == -2 && yVal == 3 && zVal == 4 && (getTile(-3, 4, 4) != null)) {
			return false;
		}
		//Special case logic for evaluating tiles interacting with rightmost tile in between 2 tiles
		else if(xVal == 9 && yVal == 4 && zVal == 4 && (getTile(10, 3, 4) != null)){
			return false;
		}

		boolean isOpenLeft = getTile(xVal - 1, yVal, zVal) == null;
		boolean isOpenRight = getTile(xVal + 1, yVal, zVal) == null;
		
		if (isOpenLeft == true || isOpenRight == true) {
			return true;
		}
		return false;
	}
	
	public void removeTile(Tile tile) {
		if (tile == null) {
			System.err.println("The tile to remove was null.");
			return;
		}
		if (tile.xVal == null || tile.yVal == null || tile.zVal == null) {
			System.err.println("The tile hasn't been placed yet.");
			return;
		}
		removeTile(tile.xVal, tile.yVal, tile.zVal);
	}
	
	public void removeTile(int xVal, int yVal, int zVal) {
		Tile tile = board.remove(getKey(xVal, yVal, zVal));
		if (tile == null) {
			System.err.println("Invalid tile");
		} else {
			
			tile.isRemoved = true;
			tile.isHighlighted = false;
			remove(tile);
			draw();
			repaint();
		}
		removedTiles.push(tile);
		
		
		//discardPanel.setPreferredSize(new Dimension(100*removedTiles.size(), 0));
		if (removedTiles.size() > 0 && scrollPane != null) {
			//scrollPane.removeAll();
			for (Tile t: removedTiles) {
				discardPanel.add(t,0);
			}
			discardPanel.revalidate();
		}
		return;
	}
	
	public void undo() {
		try {
			Tile tile1 = removedTiles.pop();
			Tile tile2 = removedTiles.pop();
			tile1.isRemoved = false;
			tile2.isRemoved = false;
			board.put(getKey(tile1.xVal, tile1.yVal, tile1.zVal), tile1);
			board.put(getKey(tile2.xVal, tile2.yVal, tile2.zVal), tile2);
			draw();
			repaint();
		} catch (EmptyStackException e) {
			return;
		}
		
		//discardPanel.setPreferredSize(new Dimension(121*removedTiles.size()+1, 121));
		if (removedTiles.size() > 0 && scrollPane != null) {
			//scrollPane.removeAll();
			for (Tile t: removedTiles) {
				discardPanel.add(t,0);
			}
			discardPanel.revalidate();
		}
	}
	
	public boolean canUndo() {
		return !removedTiles.isEmpty();
	}

	


	private List<Tile> initializeDeck() {
		List<Tile> deck = new ArrayList<>();

		for (int i = 0; i < 4; i++) {

			// Chinese numbers
			deck.add(new CharacterTile('1'));
			deck.add(new CharacterTile('2'));
			deck.add(new CharacterTile('3'));
			deck.add(new CharacterTile('4'));
			deck.add(new CharacterTile('5'));
			deck.add(new CharacterTile('6'));
			deck.add(new CharacterTile('7'));
			deck.add(new CharacterTile('8'));
			deck.add(new CharacterTile('9'));

			// Wind tiles
			deck.add(new CharacterTile('N'));
			deck.add(new CharacterTile('S'));
			deck.add(new CharacterTile('E'));
			deck.add(new CharacterTile('W'));

			// Dragon tiles
			deck.add(new CharacterTile('C'));
			deck.add(new CharacterTile('F'));
			deck.add(new WhiteDragonTile());

			// Bamboo tiles, including the bamboo 1 picture
			deck.add(new Bamboo1Tile());
			deck.add(new BambooTile(2));
			deck.add(new BambooTile(3));
			deck.add(new BambooTile(4));
			deck.add(new BambooTile(5));
			deck.add(new BambooTile(6));
			deck.add(new BambooTile(7));
			deck.add(new BambooTile(8));
			deck.add(new BambooTile(9));

			// Circle tiles, including the 'pancake'
			deck.add(new CircleTile(1));
			deck.add(new CircleTile(2));
			deck.add(new CircleTile(3));
			deck.add(new CircleTile(4));
			deck.add(new CircleTile(5));
			deck.add(new CircleTile(6));
			deck.add(new CircleTile(7));
			deck.add(new CircleTile(8));
			deck.add(new CircleTile(9));

		}

		deck.add(new FlowerTile("Chrysanthemum"));
		deck.add(new FlowerTile("Orchid"));
		deck.add(new FlowerTile("Plum"));
		deck.add(new FlowerTile("Bamboo"));
		deck.add(new SeasonTile("Spring"));
		deck.add(new SeasonTile("Summer"));
		deck.add(new SeasonTile("Fall"));
		deck.add(new SeasonTile("Winter"));

		Collections.shuffle(deck, random);

		return deck;
	}
	
	protected JPanel getDiscardPanel() {
		return discardPanel;
	}
	
	protected void setSound(boolean sound) {
		this.sound = sound;
	}
	

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}
	
	protected void stopFireworks() {
		if (fireworks != null) {
			fireworks.stop();
			fireworks = null;
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		Object source = e.getSource();
		
		
		if (source instanceof Tile) {
			if(isOpen((Tile) source) == true) {
				if (firstPick == null) {
					firstPick = (Tile) source;
					if (firstPick != null) {
						getTile(firstPick.xVal, firstPick.yVal, firstPick.zVal).isHighlighted = true;
						repaint();
					}
				}
				else if (firstPick.matches((Tile) source) && source != firstPick || (((Tile) source).matches(firstPick) && source != firstPick)){
					removeTile((Tile) source);
					removeTile(firstPick);
					firstPick = null;
				}
				
				else {
					if (firstPick != null) {
						getTile(firstPick.xVal, firstPick.yVal, firstPick.zVal).isHighlighted = false;
						firstPick = null;
						repaint();
					}
				}
			}
		}
		if (board.isEmpty()) {
			fireworks = new Fireworks(this);
			fireworks.setSound(sound);
			fireworks.fire();
		}
		
	}	


}