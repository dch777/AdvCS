//Name: Dhruv Chanana
//Period: 3B

import java.util.*;
import java.awt.*;

public class TileManager 
{
	private ArrayList<Tile> tiles = new ArrayList<Tile>();

	public void addTile(Tile rect)
	{
		tiles.add(rect);
	}

	public void drawAll(Graphics g)
	{
		for (Tile tile : tiles) {
			tile.draw(g);
		}
	}

	public void raise(int x, int y)
	{
		for (int i = tiles.size() - 1; i >= 0; i--) 
		{
			Tile tile = tiles.get(i);
			if (tile.getX() < x && tile.getX() + tile.getWidth() > x && tile.getY() < y && tile.getY() + tile.getHeight() > y)
			{
				tiles.remove(tile);
				tiles.add(tile);
				break;
			}
		}
	}

	public void lower(int x, int y)
	{
		for (int i = tiles.size() - 1; i >= 0; i--) 
		{
			Tile tile = tiles.get(i);
			if (tile.getX() < x && tile.getX() + tile.getWidth() > x && tile.getY() < y && tile.getY() + tile.getHeight() > y)
			{
				tiles.remove(tile);
				tiles.add(0, tile);
				break;
			}
		}
	}

	public void delete(int x, int y)
	{
		for (int i = tiles.size() - 1; i >= 0; i--) 
		{
			Tile tile = tiles.get(i);
			if (tile.getX() < x && tile.getX() + tile.getWidth() > x && tile.getY() < y && tile.getY() + tile.getHeight() > y)
			{
				tiles.remove(tile);
				break;
			}
		}
	}

	public void deleteAll(int x, int y)
	{
		for (int i = tiles.size() - 1; i >= 0; i--) 
		{
			Tile tile = tiles.get(i);
			if (tile.getX() < x && tile.getX() + tile.getWidth() > x && tile.getY() < y && tile.getY() + tile.getHeight() > y)
			{
				tiles.remove(tile);
			}
		}
	}

	public void shuffle(int width, int height)
	{
		Collections.shuffle(tiles);
		for (Tile tile : tiles)
		{
			tile.setX((int) (Math.random() * (width - tile.getWidth())));
			tile.setY((int) (Math.random() * (height - tile.getHeight())));
		}
	}
}
