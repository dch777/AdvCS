//Name: Dhruv Chanana
//Period: 3B

public class MyBST 
{
	BSTNode root;

	private class BSTNode {
		Integer val;
		BSTNode left, right;

		public BSTNode(Integer val)
		{
			this.val = val;
			left = right = null;
		}

		@Override
		public String toString()
		{
			return this.val.toString();
		}
	}

	public int size()
	{
		return this.size(root);
	}

	private int size(BSTNode node)
	{
		if (node == null)
		{
			return 0;
		}
		else
		{
			return 1 + this.size(node.left) + this.size(node.right);
		}
	}

	public void insert(Integer n)
	{
		root = insert(n, root);
	}

	private BSTNode insert(Integer n, BSTNode node)
	{
		if (node == null)
		{
			node = new BSTNode(n);
		}
		else if (n > node.val)
		{
			node.right = insert(n, node.right);
		}
		else if (n < node.val)
		{
			node.left = insert(n, node.left);
		}
		return node;
	}

	public boolean contains(Integer n)
	{
		return contains(n, root);
	}

	private boolean contains(Integer n, BSTNode node)
	{
		if (node == null)
		{
			return false;
		}
		else if (node.val == n)
		{
			return true;
		}
		return contains(n, node.left) || contains(n, node.right);
	}

	public Integer getMax()
	{
		if (root == null)
		{
			return null;
		}

		BSTNode node = root;
		while (node.right != null)
		{
			node = node.right;
		}
		return node.val;
	}

	public Integer getMin()
	{
		if (root == null)
		{
			return null;
		}

		BSTNode node = root;
		while (node.left != null)
		{
			node = node.left;
		}
		return node.val;
	}

	public void delete(Integer n)
	{
		root = delete(n, root);
	}

	private BSTNode delete(Integer n, BSTNode node)
	{
		if (node == null)
		{
			return node;
		}

		if (node.val == n)
		{
			if (node.left == null && node.right == null)
			{
				node = null;
			}
			else if (node.right == null)
			{
				node = node.left;
			}
			else if (node.left == null)
			{
				node = node.right;
			}
			else
			{
				node = node.right;
				while (node.left != null)
				{
					node = node.left;
				}
			}
		}
		else if (n > node.val)
		{
			node.right = delete(n, node.right);
		}
		else if (n < node.val)
		{
			node.left = delete(n, node.left);
		}

		return node;
	}

	public void print()
	{
		print(root, "");
	}

	public void print(BSTNode node, String space)
	{
		if (node == null)
		{
			return;
		}

		space += "\t";
		print(node.right, space);
		System.out.println(space + node.val);
		print(node.left, space);
	}

	public void inOrder()
	{
		inOrder(root);
	}

	private void inOrder(BSTNode node)
	{
		if (node == null)
		{
			return;
		}
		inOrder(node.left);
		System.out.print(node.val + " ");
		inOrder(node.right);
	}
}
