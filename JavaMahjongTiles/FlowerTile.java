import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FlowerTile extends PictureTile{
	
	private Image orchid = new ImageIcon(this.getClass().getResource("/images/Orchid.png")).getImage();
	private Image chry = new ImageIcon(this.getClass().getResource("/images/Chrysanthemum.png")).getImage();
	private Image plum = new ImageIcon(this.getClass().getResource("/images/Plum.png")).getImage();
	private Image bamboo = new ImageIcon(this.getClass().getResource("/images/Bamboo.png")).getImage();

	public FlowerTile(String name) {
		super(name);
		setToolTipText(toString());
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		switch(super.toString()) {
		case "Orchid":
			g.drawImage(orchid, 15, 35, 70,70, null);
			break;
		case "Chrysanthemum":
			g.drawImage(chry, 15, 35, 70,70, null);
			break;
		case "Plum":
			g.drawImage(plum, 15, 35, 70,70, null);
			break;
		case "Bamboo":
			g.drawImage(bamboo, 15, 35, 70,70, null);
			break;
		}
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Flower Tiles");

		frame.add(new FlowerTile("Chrysanthemum"));
		frame.add(new FlowerTile("Orchid"));
		frame.add(new FlowerTile("Plum"));
		frame.add(new FlowerTile("Bamboo"));

		frame.pack();
		frame.setVisible(true);
	}
	
}