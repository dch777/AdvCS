//Name: Dhruv Chanana
//Period: 3B

import java.util.*;

public class MazeSolverQueue extends MazeSolver 
{
	private MyQueue<Square> queue = new MyQueue<Square>();

	public MazeSolverQueue(Maze maze)
	{
		super(maze);
		queue.offer(maze.getStart());
	}

	@Override
	public void makeEmpty()
	{
		queue = new MyQueue<Square>();
	}

	@Override
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}

	@Override
	public void add(Square s)
	{
		queue.offer(s);
	}

	@Override
	public Square next()
	{
		return queue.poll();
	}
}
