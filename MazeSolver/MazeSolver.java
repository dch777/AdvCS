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
					add(s);
				}
			}
		}
	}

	public String getPath()
	{
		if (solved)
		{
			return "Maze Solved!";
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
