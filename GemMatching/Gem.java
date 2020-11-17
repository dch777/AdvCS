import java.awt.Font;

enum GemType {
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
}

public class Gem 
{	
	private int points;
	private GemType color;

	public Gem() 
	{
		this.color = GemType.values()[(int) (Math.random() * 2.9)];
		this.points = (int) (Math.random() * 100);
	}

	public Gem(GemType type, int points)
	{
		this.color = type;
		this.points = points;
	}


	public GemType getType() {
		return this.color;
	}

	public int getPoints() {
		return this.points;
	}

	void draw(double x, double y)
	{
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.setFont(new Font("SansSerif", Font.BOLD, 14));
		if (color == GemType.BLUE) 
		{
			StdDraw.picture(x, y, "gem_blue.png");
		}
		else if (color == GemType.ORANGE)
		{
			StdDraw.picture(x, y, "gem_orange.png");
		}
		else if (color == GemType.GREEN)
		{
			StdDraw.picture(x, y, "gem_green.png");
		}
		StdDraw.text(x, y, toString());
	}

	@Override
	public String toString()
	{
		return this.points + "";
	}
}
