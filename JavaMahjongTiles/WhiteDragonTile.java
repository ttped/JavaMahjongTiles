import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;

import javax.swing.ImageIcon;

public class WhiteDragonTile extends Tile{
	public WhiteDragonTile() {
		setToolTipText(toString());
	}
	//private Image drag = new ImageIcon(this.getClass().getResource("/images/dragon_bg.png")).getImage();
	
	public String toString() {
		return "White Dragon";
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Stroke blocks = new BasicStroke(4, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 
				0, new float[]{6, 14}, 0);
		g.setColor(Color.BLUE);
		g.drawRect(22, 42, 56, 56);
		g.drawRect(18, 38, 64, 64);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(blocks);
		g2.drawRect(20, 40, 60, 60);
		
		
		
		//g.drawImage(drag, 5, 35, 90,70, null);
	}
	
}