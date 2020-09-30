//Name: Dhruv Chanana
//Period: 3B

import java.util.*;

public class MyStack implements StackADT
{
	private Square[] stack = new Square[2];
	private int size;

	public MyStack() 
	{
		size = 0;
	}

	public MyStack(int initCap)
	{
		this();
		stack = new Square[initCap];
	}

	public boolean isEmpty()
	{
		return size == 0;
	}

	public Square peek()
	{
		if (isEmpty())
			throw new EmptyStackException();
		return stack[size - 1];
	}

	public Square pop()
	{
		if (isEmpty())
			throw new EmptyStackException();
		size--;
		return stack[size - 1];
	}

	public void push(Square item)
	{
		if (size > stack.length)
			doubleCapacity();
		size++;
		stack[size - 1] = item;
	}

	private void doubleCapacity()
	{
		Square[] tmp = stack.clone();
		stack = new Square[stack.length * 2];
		System.arraycopy(tmp, 0, stack, 0, tmp.length);
	}

	public int size()
	{
		return size;
	}

	public void clear()
	{
		size = 0;
	}

	@Override
	public String toString()
	{
		return Arrays.toString(stack);
	}
}
