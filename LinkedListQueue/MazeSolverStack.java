//Name: Dhruv Chanana
//Period: 3B

import java.util.*;

public class MazeSolverStack extends MazeSolver 
{
	private MyStack stack = new MyStack();

	public MazeSolverStack(Maze maze)
	{
		super(maze);
		stack.push(maze.getStart());
	}

	@Override
	public void makeEmpty()
	{
		stack = new MyStack();
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
