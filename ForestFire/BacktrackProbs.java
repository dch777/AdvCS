//Name: Dhruv Chanana
//Period: 3B

import java.util.*;

public class BacktrackProbs 
{
	public static void main(String[] args)
	{
		printBinary(3);
		climbStairs(4);
		campsite(2, 1);

		List<Integer> list = new ArrayList<Integer>();
		list.add(7);
		list.add(30);
		list.add(8);
		list.add(22);
		list.add(6);
		list.add(1);
		list.add(14);
		System.out.println(getMax(list, 19));
		
		System.out.println(makeChange(25));
		makeChange2(11);
		System.out.println(longestCommonSub("ABCDEFG", "BGCEHAF"));
	}

	public static void printBinary(int digits)
	{
		printBinaryHelper(digits, "");
		System.out.println();
	}

	public static void printBinaryHelper(int digits, String result)
	{
		if (result.length() == digits)
		{
			System.out.print(result + " ");
		}
		else
		{
			printBinaryHelper(digits, result + 0);
			printBinaryHelper(digits, result + 1);
		}
	}

	public static void climbStairs(int steps)
	{
		climbStairsHelper(steps, "");
	}

	public static void climbStairsHelper(int steps, String result)
	{
		if (steps <= 0) 
		{
			System.out.println(result.substring(0, result.length() - 2));
		}
		else if(steps >= 2)
		{
			climbStairsHelper(steps - 2, result + "2, ");
			climbStairsHelper(steps - 1, result + "1, ");
		}
		else
		{
			climbStairsHelper(steps - 1, result + "1, ");
		}
	}

	public static void campsite(int x, int y)
	{
		campsiteHelper(x, y, "");
	}

	public static void campsiteHelper(int x, int y, String result)
	{
		if (x == 0 && y == 0)
		{
			System.out.println(result);
		}
		else if(x >= 0 && y >= 0)
		{
			campsiteHelper(x - 1, y, result + "E ");
			campsiteHelper(x - 1, y - 1, result + "NE ");
			campsiteHelper(x, y - 1, result + "N ");
		}
	}

	public static int getMax(List<Integer> list, int limit) 
	{
		int[] max = {0};
		getMaxHelper(list, limit, 0, max);
		return max[0];
	}

	public static void getMaxHelper(List<Integer> list, int limit, int sum, int[] max) {
    		if (sum > max[0] && sum <= limit) 
		{
        		max[0] = sum;
    		}
    		if (list.size() != 0) 
		{
        		int num = list.remove(0);
        		getMaxHelper(list, limit, sum + num, max);
        		getMaxHelper(list, limit, sum, max);
        		list.add(num);
    		}
	}

	public static int makeChange(int amount)
	{
		HashSet<String> set = new HashSet<String>();
		makeChangeHelper(amount, new int[4], set);
		return set.size();
	}

	public static void makeChange2(int amount)
	{
		HashSet<String> set = new HashSet<String>();
		makeChangeHelper(amount, new int[4], set);
		System.out.println(" Q  D  N  P");
		System.out.println("-----------");
		for (String coins : set) 
		{
			System.out.println(coins);
		}
	}

	public static void makeChangeHelper(int amount, int[] coins, HashSet<String> set)
	{
		if (amount == 0) 
		{
			set.add(Arrays.toString(coins));
		}
		else if(amount > 0)
		{
			int[] quarterArray = coins.clone();
			quarterArray[0]++;
			makeChangeHelper(amount - 25, quarterArray, set);
			int[] dimeArray = coins.clone();
			dimeArray[1]++;
			makeChangeHelper(amount - 10, dimeArray, set);
			int[] nickelArray = coins.clone();
			nickelArray[2]++;
			makeChangeHelper(amount - 5, nickelArray, set);
			int[] pennyArray = coins.clone();
			pennyArray[3]++;
			makeChangeHelper(amount - 1, pennyArray, set);
		}
	}

	public static String longestCommonSub(String a, String b)
	{
		if (a.length() == 0 || b.length() == 0)
		{
			return "";
		}
		else if (a.charAt(0) == b.charAt(0))
		{
			return a.charAt(0) + longestCommonSub(a.substring(1), b.substring(1));
		}
		else
		{
			String s1 = longestCommonSub(a, b.substring(1));
			String s2 = longestCommonSub(a.substring(1), b);
			return s2.length() > s1.length() ? s2 : s1;
		}
	}
}
