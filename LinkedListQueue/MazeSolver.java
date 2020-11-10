//Name: Dhruv Chanana
//Period: 3B

import java.util.*;

public abstract class MazeSolver 
{
	protected Maze maze;
	protected boolean solved = false;

	public MazeSolver(Maze maze)
	{
		this.maze = maze;
	}

	abstract void makeEmpty();
	abstract boolean isEmpty();
	abstract void add(Square s);
	abstract Square next();

	boolean isSolved()
	{
		return isEmpty() || solved;
	}

	void step()
	{
		if (!isEmpty())
		{
			Square currentSquare = next();
			currentSquare.setStatus(Square.EXPLORED);
			if (currentSquare == maze.getExit())
			{
				solved = true;
				return;
			}
			for (Square s : maze.getNeighbors(currentSquare)) 
			{
				if (s.getType() != Square.WALL && s.getStatus() != Square.EXPLORED)
				{
					s.setStatus(Square.WORKING);
					s.setPrevious(currentSquare);
					add(s);
				}
			}
		}
	}

	public String getPath()
	{
		if (solved)
		{
			String path = "";
			Square current = this.maze.getExit();
			while (current.getPrevious() != null)
			{
				path = String.format("[%o, %o]\n", current.getRow(), current.getCol()) + path;
				current = current.getPrevious();
			}
			path = String.format("[%o, %o]\n", this.maze.getStart().getRow(), this.maze.getStart().getCol()) + path;
			return path;
		}
		else if (isEmpty())
		{
			return "Maze Unsolvable";
		}
		else
		{
			return "Not yet solved";
		}
	}

	public void solve()
	{
		while (!isSolved())
		{
			step();
		}
	}
}
