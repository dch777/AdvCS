//Name: Dhruv Chanana
//Period: 3B

import java.util.*;

public class MyStack
{
	private Integer[] stack = new Integer[2];
	private int size;

	public MyStack() 
	{
		size = 0;
	}

	public MyStack(int initCap)
	{
		this();
		stack = new Integer[initCap];
	}

	public boolean isEmpty()
	{
		return size == 0;
	}

	public Integer peek()
	{
		if (isEmpty())
			throw new EmptyStackException();
		return stack[size - 1];
	}

	public Integer pop()
	{
		if (isEmpty())
			throw new EmptyStackException();
		size--;
		return stack[size];
	}

	public void push(Integer item)
	{
		if (size >= stack.length)
			doubleCapacity();
		size++;
		stack[size - 1] = item;
	}

	private void doubleCapacity()
	{
		Integer[] tmp = stack.clone();
		stack = new Integer[stack.length * 2];
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
