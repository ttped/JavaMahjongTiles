
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;



public class MahjongBoard extends JFrame {
	private final String operationString =
			"Play: Starts a new game\n" +
			"Restart: Restarts the current game without retaining any memory of redo or undo operations.\n" +
			"New Numbered Game: Starts a new game with the entered nubmer as the game seed.\n" +
			"Undo/Redo: Undoes the last performed move if available.\n" +
			"Sound: Sets the sound on or off.\n" +
			"Toggle removed Tiles: Toggles the display on the removed tiles window\n\n";
	private final String rulesString = 
			"Click on any tile to highlight it. When one tile is highlighted, clicking" +
			" on another tile will check to see if they are a match. If the tiles are a" +
			" match, the tiles will be removed. The following are the types of tiles:\n" +
			"\tCircle tiles - match the same number of circles on a tile\n" +
			"\tBamboo tiles - match the same number of bamboo on a tile, the one bamboo tile has a picture\n" + "\tof a bird\n" +
			"\tCharacter tiles - Chinese number symbols, match the same number on tiles to remove\n" +
			"\tFlower tiles - pictures of flowers, match any of them to remove\n" +
			"\tSeason tiles - match any of butterfly, sun, snowflake and leaf to remove\n\n" +
			"After any tile has been removed, it will show in the small square window to the right.\n"+
			"There is also a undo button to undo the last played move";
	
	private long restartSeed;
	private static final int BOARD_WIDTH = 1600;
	private static final int BOARD_HEIGHT = 1100;
	private GamePanel gamePanel;
	
	private final String title = "Mahjong Tiles \t";
	

	private JFrame removedFrame = null;
	private JFrame helpFrame = null;

	public MahjongBoard() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int selection =
						JOptionPane.showConfirmDialog(e.getComponent(),
						"Do you want to quit the game?",
						"Exit Game",
						JOptionPane.YES_NO_OPTION);
				if (selection == 0) {
					System.exit(0);
				}
			}
		});

		setSize(BOARD_WIDTH, BOARD_HEIGHT);
		setLayout(new BorderLayout());
		setMenu();
		
		
	}
	
	
	
	private void newGame() throws InterruptedException {
		remove(gamePanel);
		remove(removedFrame);
		removedFrame.dispose();
		setMenu();
	}
	
	private void loadGame() throws InterruptedException {
		String name = JOptionPane.showInputDialog(null, "Please enter a 6 digit number to load game", "Data Input", JOptionPane.QUESTION_MESSAGE);
		int num;
		if (name == null || name.length() == 0) {
			JOptionPane.showMessageDialog(null, "Invalid input");
			return;
		}
		try {
			num = Integer.parseInt(name);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid input");
		    return;
		}
		remove(gamePanel);
		remove(removedFrame);
		removedFrame.dispose();
		
		
		int width = getContentPane().getWidth();
		int height = getContentPane().getHeight();

		restartSeed = num;
		gamePanel = new GamePanel(width, height, (long) num);
		add(gamePanel);
		
		drawMenu();
		

		setTitle(title + "(Game Number: " + num + ")");
	}
	
	public void restartGame() {
		remove(gamePanel);
		remove(removedFrame);
		removedFrame.dispose();
		
		
		int width = getContentPane().getWidth();
		int height = getContentPane().getHeight();

		gamePanel = new GamePanel(width, height, (long) restartSeed);
		add(gamePanel);
		
		drawMenu();	

		setTitle(title + "(Game Number: " + restartSeed + ")");
	}
	
	
	
	public void setMenu() {
		int width = getContentPane().getWidth();
		int height = getContentPane().getHeight();

		Long randomNumber = new Date().getTime() % 1000000;
		restartSeed = randomNumber;
		gamePanel = new GamePanel(width, height, randomNumber);
		
		add(gamePanel);
		
		
		drawMenu();
		setTitle(title + "(Game Number: " + randomNumber + ")");
		
	}
	
	public void drawMenu() {
		JScrollPane scrollPane = new JScrollPane(gamePanel.getDiscardPanel());
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(300, 145));
		add(scrollPane, BorderLayout.NORTH);
		
		removedFrame = new JFrame("Removed Tiles");
		removedFrame.add(scrollPane, BorderLayout.NORTH);
		removedFrame.setLocation(1600, 0);
		removedFrame.setVisible(true);
		removedFrame.setSize(120, 180);
		removedFrame.setLayout(new BorderLayout());
		
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Game");
		JMenuItem item = new JMenuItem("Play -- Start a new game");
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					newGame();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menu.add(item);
		
		item = new JMenuItem("Restart");
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				restartGame();
			}
		});
		menu.add(item);
		
		item = new JMenuItem("New Numbered Game");
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					loadGame();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menu.add(item);
		
		item = new JMenuItem("Toggle removed tiles");
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (removedFrame.isVisible())
				removedFrame.setVisible(false);
				else {
					removedFrame.setVisible(true);
				}
			}
		});
		menu.add(item);
		menubar.add(menu);
		
		 menu = new JMenu("Sound");
		 item = new JCheckBoxMenuItem("Sound");
			((JCheckBoxMenuItem) item).setSelected(true);
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (!(e.getSource() instanceof JCheckBoxMenuItem)) {
						return;
					}

					JCheckBoxMenuItem checkbox = (JCheckBoxMenuItem) e.getSource();
					gamePanel.setSound(checkbox.isSelected());
				}
			});
			menu.add(item);
		 menubar.add(menu);
		 
		 menu = new JMenu("Move");
		 item = new JMenuItem("Undo");
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					gamePanel.undo();
				}
			});
			menu.add(item);
			menubar.add(menu);
		 
			menu = new JMenu("Help");
			item = new JMenuItem("Operation");
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(helpFrame == null) {
						helpFrame = new JFrame();
					}
					else {
						remove(helpFrame);
						helpFrame = new JFrame();
					}
					JPanel panel = new JPanel();
					JTextArea text = new JTextArea();
					JScrollPane scrollPane = new JScrollPane(text);
					text.setText(operationString);
					text.setLineWrap(true);
					text.setWrapStyleWord(true);
					text.setTabSize(2);
					scrollPane.setPreferredSize(new Dimension(550, 350));
					panel.add(scrollPane);
					
					helpFrame.setTitle("Operation Instructions");
					helpFrame.add(panel);
					helpFrame.setVisible(true);
					helpFrame.setSize(600, 400);
				}
			});
			menu.add(item);
		 
			item = new JMenuItem("Game Rules");
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(helpFrame == null) {
						helpFrame = new JFrame();
					}
					else {
						remove(helpFrame);
						helpFrame = new JFrame();
					}
					JPanel panel = new JPanel();
					JTextArea text = new JTextArea();
					JScrollPane scrollPane = new JScrollPane(text);
					text.setText(rulesString);
					text.setLineWrap(true);
					text.setWrapStyleWord(true);
					text.setTabSize(2);
					scrollPane.setPreferredSize(new Dimension(550, 350));
					panel.add(scrollPane);
					helpFrame.setTitle("Game Rules");
					helpFrame.add(panel);
					helpFrame.setVisible(true);
					helpFrame.setSize(600, 400);
				}
			});
			menu.add(item);
		 menubar.add(menu);
		//menubar.revalidate();
		menubar.setPreferredSize(new Dimension(0,25));
		add(menubar, BorderLayout.NORTH);
		setResizable(false);
		setVisible(true);
	}

	
	public static void main(String[] args) {
		new MahjongBoard();
	}

}