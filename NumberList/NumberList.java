//Name: Dhruv Chanana
//Period: 3B

public class NumberList 
{

	private Integer[] list;
	private int size;

	public NumberList() 
	{
		list = new Integer[2];
		size = 0;
	}

	public int size()
	{
		return size;
	}

	public boolean isEmpty()
	{
		return list.length == 0;
	}

	public String toString()
	{
		String str = "[";
		for (Integer i : list) 
		{
			str += i.toString() + " ";
		}
		return str + "]";
	}

	private void doubleCapacity()
	{
		Integer[] tmp = this.list.clone();
		this.list = new Integer[this.list.length * 2];
		System.arraycopy(tmp, 0, this.list, 0, tmp.length);
	}

	public void add(int index, Integer val)
	{
		if (index > size || index < 0) 
		{
			throw new IndexOutOfBoundsException();
		}

		if (size == list.length)
		{
			this.doubleCapacity();
		}

	}

	public boolean add(Integer element)
	{

	}

	public Integer get(int index)
	{

	}

	public Integer set(int index, Integer val)
	{

	}

	public Integer remove(int index)
	{

	}
}
