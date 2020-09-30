//Name: Dhruv Chanana
//Period: 3B

import java.util.*;

public class Runner 
{
	public static void main(String[] args) 
	{
		//2
		int[] array = {1, 3, 5, 0, -1};
		Stack<Integer> stack = StackProbs.makeStack(array);
		System.out.println(StackProbs.doubleUp(stack));

		//3
		array = new int[] {2, 9, -4, 3, -1, 0, -6};
		stack = StackProbs.makeStack(array);
		System.out.println(StackProbs.posAndNeg(stack));

		//4
		array = new int[] {7, 23, -7, 0, 22, -8, 4, 5};
		stack = StackProbs.makeStack(array);
		System.out.println(StackProbs.shiftByN(stack, 3));

		//5
		System.out.println(StackProbs.reverseVowels("hello how are you"));
	}
}
