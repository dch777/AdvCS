public class GemList 
{
	Node head;

	private class Node
	{
		Gem gem;
		Node next;

		public Node(Gem gem)
		{
			this.gem = gem;
		}
	}

	public void draw(double y)
	{
		Node current = head;
		for (int i = 0; current != null; i++)
		{
			current.gem.draw(GemGame.indexToX(i), y);
			current = current.next;
		}
	}

	public int size()
	{
		Node current = head;
		int i;
		for (i = 0; current != null; i++) 
		{
			current = current.next;
		}
		return i;
	}

	public void insertBefore(Gem gem, int index)
	{
		if (size() == 0) {
			head = new Node(gem);
			return;
		}

		Node current = head;
		for (int i = 0; i < index - 1 && current.next != null; i++) 
		{
			current = current.next;
		}
		Node tmp = current.next;
		current.next = new Node(gem);
		current.next.next = tmp;
	}

	public int score()
	{
		Node current = head;
		int score = 0;
		int multiplier = 1;
		int blockScore = 0;
		while (current != null)
		{
			if (current.next != null && current.next.gem.getType() == current.gem.getType())
			{
				blockScore += current.gem.getPoints();
				multiplier++;
			}
			else
			{
				blockScore += current.gem.getPoints();
				score += blockScore * multiplier;
				multiplier = 1;
				blockScore = 0;
			}
			current = current.next;
		}
		return score;
	}

	@Override
	public String toString()
	{
		if (head == null)
		{
			return "[]";
		}

		Node current = head;
		String str = "[";
		while (current != null)
		{
			str += current.gem.toString() + ", ";
			current = current.next;
		}
		return str.substring(0, str.length() - 2) + "]";
	}

	public static void main(String [] args)
	{
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);		
		
		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);
		
		list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);
		
		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);
		
		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);
		
		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);
		
		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);		
	}	
}
