//Name: Dhruv Chanana
//Period: 3B

import java.util.*;

public class RecursionProbs 
{
	public static void main(String[] args) 
	{
		System.out.println(sumReciprocals(10));
		System.out.println(productOfEvens(4));
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(7);
		stack.push(9);
		stack.push(12);
		System.out.println(stack);
		doubleUp(stack);
		System.out.println(stack);
		countToBy(34, 5);
		System.out.println();
		System.out.println(matchingDigits(298892, 7892));
		printThis(8);
		System.out.println();
		printThis(9);
		System.out.println();
		printNums2(10);
		System.out.println();
	}

	public static double sumReciprocals(int n)
	{
		if (n > 1) 
		{
			return sumReciprocals(n - 1) + (1.0 / (double) n);
		}
		else
		{
			return 1;
		}
	}

	public static int productOfEvens(int n)
	{
		if (n > 1)
		{
			return productOfEvens(n - 1) * (n * 2);
		}
		else
		{
			return 2;
		}
	}

	public static void doubleUp(Stack<Integer> nums)
	{
		if (nums.size() > 1)
		{
			int tmp = nums.pop();
			doubleUp(nums);
			nums.push(tmp);
			nums.push(tmp);
			return;
		}
		else
		{
			nums.push(nums.peek());
			return;
		}
	}

	public static void countToBy(int n, int m)
	{
		int tmp = n - m;
		if (tmp > 0)
		{
			countToBy(tmp, m);
			System.out.print(", ");
		}
		System.out.print(n);
	}

	public static int matchingDigits(int a, int b)
	{
		if (a % 10 != a && b % 10 != b)
		{
			return (a % 10 == b % 10 ? 1 : 0) + matchingDigits(a / 10, b / 10);
		}
		else
		{
			return a % 10 == b % 10 ? 1 : 0;
		}
	}

	public static void printThis(int n)
	{
		if (n > 2)
		{
			System.out.print("<");
			printThis(n - 2);
			System.out.print(">");
		}
		else
		{
			System.out.print(n == 1 ? "*" : "**");
		}
	}

	public static void printNums2(int n)
	{
		if (n > 2) 
		{
			System.out.print((int) Math.ceil((double) n / 2.0) + " ");
			printNums2(n - 2);
			System.out.print((int) Math.ceil((double) n / 2.0) + " ");
		}
		else
		{
			System.out.print(n == 1 ? "1 " : "1 1 ");
		}
	}
}
