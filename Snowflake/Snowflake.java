import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowFlakePanel extends JPanel
{
	public SnowFlakePanel()
	{
		super.setPreferredSize(new Dimension(400, 400));
		super.setBackground(Color.WHITE);
	}

	public void paintComponent(Graphics g)
	{
		int width  = getWidth();
		int height = getHeight();

		super.paintComponent(g);

		/*
		 * DRAWING CODE BELOW
		 */
		for (int i = 0; i < 10; i++) 
		{
			int redValue = (int) (Math.random() * 255);
			int blueValue = (int) (Math.random() * 255);
			int greenValue = (int) (Math.random() * 255);
			g.setColor(new Color(redValue, greenValue, blueValue));
			drawStar(g, (int) (Math.random() * width / 10), (int) (Math.random() * (width - 50)) + 25, (int) (Math.random() * (height - 50)) - 25);
		}
	}

	public static void drawStar(Graphics g, int diameter, int x, int y)
	{
		if (diameter > 10)
		{
			for (double rad = 0; rad <= Math.PI * 2; rad += Math.PI / 3)
			{
				g.drawLine((int) (-1 * diameter * Math.cos(rad)) + x, (int) (-1 * diameter * Math.sin(rad)) + y, (int) (diameter * Math.cos(rad)) + x, (int) (diameter * Math.sin(rad)) + y);
				drawStar(g, diameter / 3, (int) (-1 * diameter * Math.cos(rad)) + x, (int) (-1 * diameter * Math.sin(rad)) + y);
				drawStar(g, diameter / 3, (int) (diameter * Math.cos(rad)) + x, (int) (diameter * Math.sin(rad)) + y);
			}
		}
	}

}

public class Snowflake
{
	public static void main ( String[] args )
	{
		/*
		 * A frame is a container for a panel
		 * The panel is where the drawing will take place
		 */
		JFrame frame = new JFrame("Snowflake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new SnowFlakePanel());
		frame.pack();
		frame.setVisible(true);
	}

}
