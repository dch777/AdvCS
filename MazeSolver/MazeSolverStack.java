//Name: Dhruv Chanana
//Period: 3B

import java.util.*;

public class MazeSolverStack extends MazeSolver 
{
	private Stack<Square> stack = new Stack<Square>();

	public MazeSolverStack(Maze maze)
	{
		super(maze);
		stack.push(maze.getStart());
	}

	@Override
	public void makeEmpty()
	{
		stack = new Stack<Square>();
	}

	@Override
	public boolean isEmpty()
	{
		return stack.isEmpty();
	}

	@Override
	public void add(Square s)
	{
		stack.push(s);
	}

	@Override
	public Square next()
	{
		return stack.pop();
	}
}
