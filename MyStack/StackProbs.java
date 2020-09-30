//Name: Dhruv Chanana
//Period: 3B

import java.util.*;

public class StackProbs 
{
	public static Stack<Integer> makeStack(int[] nums) 
	{
		Stack<Integer> stack = new Stack<>();
		for (int num : nums)
			stack.push(num);
		return stack;
	}

	public static Stack<Integer> doubleUp(Stack<Integer> nums)
	{
		Stack<Integer> output = new Stack<Integer>();
		while (!nums.isEmpty())
		{
			output.push(nums.peek());
			output.push(nums.pop());
		}
		return output;
	}

	public static Stack<Integer> posAndNeg(Stack<Integer> nums)
	{
		Stack<Integer> output = new Stack<Integer>();
		for (int num : nums)
		{
			if (num < 0)
				output.push(num);
		}
		for (int num : nums)
		{
			if (num >= 0)
				output.push(num);
		}
		return output;
	}

	public static Stack<Integer> shiftByN(Stack<Integer> nums, int n)
	{
		Stack<Integer> output = new Stack<Integer>();
		Stack<Integer> tmp = new Stack<Integer>();
		while (nums.size() > n)
			tmp.push(nums.pop());
		while (!tmp.isEmpty())
			output.push(tmp.pop());
		while (!nums.isEmpty())
			output.push(nums.pop());
		return output;
	}

	public static String reverseVowels(String str)
	{
		Stack<Character> vowels = new Stack<Character>();
		Stack<Integer> indices = new Stack<Integer>();
		char[] output = str.toCharArray();

		for (int i = 0; i < output.length; i++)
		{
			if (output[i] == 'a' || output[i] == 'e' || output[i] == 'i' || output[i] == 'o' || output[i] == 'u')
			{
				indices.push(i);
				vowels.push(output[i]);
			}
		}

		for (int index : indices)
		{
			output[index] = vowels.pop();
		}

		return String.valueOf(output);
	}

	public static boolean bracketBalance(String s)
	{
		char[] initial = s.toCharArray();
		for (int i = 0; i < initial.length; i++)
		{

		}
		return true;
	}
}
