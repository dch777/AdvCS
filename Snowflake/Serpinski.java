import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SerpinskiPanel extends JPanel
{
	public SerpinskiPanel()
	{
		super.setPreferredSize(new Dimension(400, 400));
		super.setBackground(Color.WHITE);
	}

	public void paintComponent(Graphics g)
	{
		int width  = getWidth();

		super.paintComponent(g);
		g.setColor(Color.BLUE);
		drawTriangle(g, width, 0, 0);
	}

	public static void drawTriangle(Graphics g, int side, int x, int y)
	{
		if (side > 20) 
		{
			g.drawPolygon(new int[]{x, x, x + side}, new int[]{y, y + side, y}, 3);
			g.drawPolygon(new int[]{x + (side / 2), x, x + (side / 2)}, new int[]{y, y + (side / 2), y + (side / 2)}, 3);
			drawTriangle(g, side / 2, x, y);
			drawTriangle(g, side / 2, x, y + (side / 2));
			drawTriangle(g, side / 2, x + (side / 2), y);
		}
	}

}

public class Serpinski
{
	public static void main ( String[] args )
	{
		/*
		 * A frame is a container for a panel
		 * The panel is where the drawing will take place
		 */
		JFrame frame = new JFrame("Serpinski");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new SerpinskiPanel());
		frame.pack();
		frame.setVisible(true);
	}

}

