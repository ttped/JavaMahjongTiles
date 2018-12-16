import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SeasonTile extends PictureTile{

	private Image spring = new ImageIcon(this.getClass().getResource("/images/Spring.png")).getImage();
	private Image summer = new ImageIcon(this.getClass().getResource("/images/Summer.png")).getImage();
	private Image fall = new ImageIcon(this.getClass().getResource("/images/Fall.png")).getImage();
	private Image winter = new ImageIcon(this.getClass().getResource("/images/Winter.png")).getImage();
	
	public SeasonTile(String name)
	{
		super(name);
	}
	
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		switch(super.toString()){
		case "Spring":
			g.drawImage(spring, 15, 35, 70,70, null);
			break;
		case "Summer":
			g.drawImage(summer, 15, 35, 70,70, null);
			break;
		case "Fall":
			g.drawImage(fall, 15, 35, 70,70, null);
			break;
		case "Winter":
			g.drawImage(winter, 15, 35, 70,70, null);
			break;
		}
	}

	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Season Tiles");

		frame.add(new SeasonTile("Spring"));
		frame.add(new SeasonTile("Summer"));
		frame.add(new SeasonTile("Fall"));
		frame.add(new SeasonTile("Winter"));

		frame.pack();
		frame.setVisible(true);
	}
}