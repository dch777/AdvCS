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
		return this.size;
	}

	public boolean isEmpty()
	{
		return this.size == 0;
	}

	public String toString()
	{
		String str = "[";
		for (int i = 0; i < size; i++) 
		{
			str += this.list[i].toString() + " ";
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
		if (index > this.size || index < 0) 
		{
			throw new IndexOutOfBoundsException();
		}

		if (size == this.list.length)
		{
			this.doubleCapacity();
		}

		for (int i = this.size; i > index; i--)
		{
			this.list[i] = this.list[i - 1];
		}

		this.list[index] = val;
		this.size++;
	}

	public boolean add(Integer val)
	{
		this.add(this.size, val);
		return true;
	}

	public Integer get(int index)
	{
		if (index >= this.size || index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		return this.list[index];
	}

	public Integer set(int index, Integer val)
	{
		if (index >= this.size || index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		Integer former = this.list[index];
		this.list[index] = val;
		return former;
	}

	public Integer remove(int index)
	{
		if (index >= this.size || index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		Integer former = this.list[index];
		for (int i = index; i < size - 1; i++)
		{
			this.list[i] = this.list[i + 1];
			this.list[i + 1] = null;
		}
		this.size--;
		return former;
	}
}
