//Name: Dhruv Chanana
//Period: 3B

import java.util.*;

public class Runner 
{
	public static void main(String[] args) 
	{
		QueueProbs probs = new QueueProbs();
		Queue<Integer> nums = new LinkedList<Integer>(Arrays.asList(3, 5, 4, 17, 6, 83, 1, 84, 16, 37));

		//3
		System.out.println(probs.evenFirst(nums));

		//5
		System.out.println(probs.sieveOfEratosthenes(100));
	}
}
