//Name: Dhruv Chanana
//Period: 3B

import java.util.*;

public class MyQueue<T>
{
	private MyLinkedList<T> queue;

	public MyQueue() 
	{
		queue = new MyLinkedList<T>();
	}

	public boolean isEmpty()
	{
		return queue.isEmpty();
	}

	public T poll()
	{
		return queue.remove(0);
	}

	public void offer(T item)
	{
		queue.add(item);
	}

	public int size()
	{
		return queue.size();
	}

	public void clear()
	{
		queue = new MyLinkedList<T>();
	}

	@Override
	public String toString()
	{
		return queue.toString();
	}
}
