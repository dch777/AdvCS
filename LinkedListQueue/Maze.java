//Name: Dhruv Chanana
//Period: 3B

import java.util.*;
import java.io.*;

public class Maze 
{
	Square start;
	Square exit;
	Square[][] maze;

	public Maze() {}

	public boolean loadMaze(String fileName)
	{
		try 
		{
			Scanner file = new Scanner(new File(fileName));
			maze = new Square[file.nextInt()][file.nextInt()];
			for (int row = 0; row < maze.length; row++)
			{
				for (int col = 0; col < maze[row].length; col++)
				{
					maze[row][col] = new Square(row, col, file.nextInt());
					if (maze[row][col].getType() == Square.START)
					{
						start = maze[row][col];
					} 
					else if (maze[row][col].getType() == Square.EXIT) 
					{
						exit = maze[row][col];
					}
				}
			}
			file.close();
			return true;
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			return false;
		}
	}

	public List<Square> getNeighbors(Square s)
	{
		List<Square> neighbors = new ArrayList<Square>();
		if (s.getRow() > 0)
		{
			neighbors.add(maze[s.getRow() - 1][s.getCol()]);
		}
		if (s.getCol() < maze[0].length - 1)
		{
			neighbors.add(maze[s.getRow()][s.getCol() + 1]);
		}
		if (s.getRow() < maze.length - 1)
		{
			neighbors.add(maze[s.getRow() + 1][s.getCol()]);
		}
		if (s.getCol() > 0)
		{
			neighbors.add(maze[s.getRow()][s.getCol() - 1]);
		}
		return neighbors;
	}

	public Square getStart()
	{
		return start;
	}

	public Square getExit() 
	{
		return exit;
	}

	void reset()
	{
		for (Square[] row : maze)
		{
			for (Square square : row)
			{
				square.reset();
			}
		}
	}

	public String toString()
	{
		String str = "";
		for (Square[] row : maze)
		{
			for (Square square : row)
			{
				str += square.toString() + " ";
			}
			str += "\n";
		}
		return str;
	}
}
