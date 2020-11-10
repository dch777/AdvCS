//Name: Dhruv Chanana
//Period: 3B

import java.util.*;

public class MyLinkedList<T>
{
	ListNode head;

	public MyLinkedList()
	{
		this.head = null;
	}

	public MyLinkedList(T val)
	{
		this.head = new ListNode(val);
	}

	private class ListNode
	{
		T val;
		ListNode next;

		public ListNode(T val) 
		{
			this.val = val;
		}

		@Override
		public String toString()
		{
			return "" + this.val;
		}
	}

	public void add(T newVal)
	{
		if (isEmpty())
		{
			head = new ListNode(newVal);
			return;
		}

		ListNode current = head;
		while (current.next != null)
		{
			current = current.next;
		}
		current.next = new ListNode(newVal);
	}

	public boolean contains(T target)
	{
		ListNode current = head;
		while (current != null)
		{
			if (current.val == target)
			{
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public T get(int index)
	{
		ListNode current = head;
		for (int i = 0; i < index; i++) 
		{
			current = current.next;
		}
		return current.val;
	}

	public int indexOf(T target)
	{
		ListNode current = head;
		int i = 0;
		while (current != null)
		{
			if (current.val == target)
			{
				return i;
			}
			i++;
			current = current.next;
		}
		return -1;
	}

	public void set(T newVal, int index)
	{
		ListNode current = head;
		for (int i = 0; i < index; i++) 
		{
			current = current.next;
		}
		current.val = newVal;
	}

	public int size()
	{
		ListNode current = head;
		int i;
		for (i = 0; current != null; i++) {
			current = current.next;
		}
		return i;
	}

	public boolean isEmpty()
	{
		return head == null;
	}

	public T remove(int index)
	{
		if (index == 0)
		{
			T tmp = head.val;
			head = head.next;
			return tmp;
		}

		ListNode current = head;
		for (int i = 0; i < index - 1; i++) 
		{
			current = current.next;
		}
		ListNode tmp = current.next;
		current.next = current.next.next;
		return tmp.val;
	}

	public void add(T newVal, int index)
	{
		ListNode current = head;
		for (int i = 0; i < index - 1; i++) 
		{
			current = current.next;
		}
		ListNode tmp = current.next;
		current.next = new ListNode(newVal);
		current.next.next = tmp;
	}

	@Override
	public String toString()
	{
		if (isEmpty())
		{
			return "[]";
		}

		ListNode current = head;
		String str = "[";
		while (current != null)
		{
			str += current.toString() + ", ";
			current = current.next;
		}
		return str.substring(0, str.length() - 2) + "]";
	}
}
