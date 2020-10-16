//Name: Dhruv Chanana
//Period: 3B

import java.util.*;

public class QueueProbs 
{
	public Queue<Integer> evenFirst(Queue<Integer> nums)
	{
		Queue<Integer> output = new LinkedList<Integer>();
		Queue<Integer> tmp = new LinkedList<Integer>();
		while (!nums.isEmpty()) 
		{
			if (nums.peek() % 2 == 0)
			{
				output.offer(nums.poll());
			}
			else 
			{
				tmp.offer(nums.poll());
			}
		}
		while (!tmp.isEmpty())
		{
			output.offer(tmp.poll());
		}
		return output;
	}

	public Stack<Integer> sieveOfEratosthenes(int n)
	{
		Queue<Integer> initial = new LinkedList<Integer>();
		Stack<Integer> output = new Stack<Integer>();

		for (int i = 2; i <= n; i++) 
		{
			initial.offer(i);
		}
		
		while (!initial.isEmpty())
		{
			output.push(initial.poll());
			for (int i = 0; i < initial.size(); i++) 
			{
				if (initial.peek() % output.peek() == 0)
				{
					initial.poll();
					i--;
				} 
				else 
				{
					initial.offer(initial.poll());
				}
			}
		}

		return output;
	}
}
