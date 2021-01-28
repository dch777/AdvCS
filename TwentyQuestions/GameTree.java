import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A model for the game of 20 questions
 *
 * @author Rick Mercer
 */
public class GameTree
{

	private Scanner input;
	private Node root;
	private String currentFile;
	private Node currentNode;
	private Node lastNode;
	private Choice lastChoice;

	private class Node 
	{
		String value;
		Node left;
		Node right;

		public Node(String value) 
		{
			this.value = value;
		}

		@Override
		public String toString()
		{
			return value;
		}
	}

	/**
	 * Constructor needed to create the game.
	 *
	 * @param fileName
	 *          this is the name of the file we need to import the game questions
	 *          and answers from.
	 */
	public GameTree(String fileName)
	{
		currentFile = fileName;
		try 
		{
			input = new Scanner(new File(fileName));
		} 
		catch(FileNotFoundException e)
		{
			System.out.println("Invalid filename");
		}

		root = build(input);
		currentNode = root;
	}

	private Node build(Scanner input)
	{
		String nodeText = input.nextLine().trim();
		Node current = new Node(nodeText);
		if (nodeText.endsWith("?"))
		{
			current.left = build(input);
			current.right = build(input);
		}
		return current;
	}

	/*
	 * Add a new question and answer to the currentNode. If the current node has
	 * the answer chicken, theGame.add("Does it swim?", "goose"); should change
	 * that node like this:
	 */
	// -----------Feathers?-----------------Feathers?------
	// -------------/----\------------------/-------\------
	// ------- chicken  horse-----Does it swim?-----horse--
	// -----------------------------/------\---------------
	// --------------------------goose--chicken-----------
	/**
	 * @param newQ
	 *          The question to add where the old answer was.
	 * @param newA
	 *          The new Yes answer for the new question.
	 */
	public void add(String newQ, String newA)
	{
		Node tmp = currentNode;
		currentNode = new Node(newQ);
		currentNode.left = new Node(newA);
		currentNode.right = tmp;

		if (lastChoice == Choice.Yes)
		{
			lastNode.left = currentNode;
		}
		else
		{
			lastNode.right = currentNode;
		}
	}

	/**
	 * True if getCurrent() returns an answer rather than a question.
	 *
	 * @return False if the current node is an internal node rather than an answer
	 *         at a leaf.
	 */
	public boolean foundAnswer()
	{
		return !currentNode.value.endsWith("?");
	}

	/**
	 * Return the data for the current node, which could be a question or an
	 * answer.  Current will change based on the users progress through the game.
	 *
	 * @return The current question or answer.
	 */
	public String getCurrent()
	{
		return currentNode.value;
	}

	/**
	 * Ask the game to update the current node by going left for Choice.yes or
	 * right for Choice.no Example code: theGame.playerSelected(Choice.Yes);
	 *
	 * @param yesOrNo
	 */
	public void playerSelected(Choice yesOrNo)
	{
		lastChoice = yesOrNo;
		lastNode = currentNode;
		if (yesOrNo == Choice.Yes)
		{
			currentNode = currentNode.left;
		}
		else
		{
			currentNode = currentNode.right;
		}
	}

	/**
	 * Begin a game at the root of the tree. getCurrent should return the question
	 * at the root of this GameTree.
	 */
	public void reStart()
	{
		currentNode = root;
	}

	@Override
	public String toString()
	{
		return toStringHelper(root, 0);
	}

	public String toStringHelper(Node node, int depth)
	{
		if (node == null)
		{
			return "";
		}
		String str = "";
		str += toStringHelper(node.right, depth + 1);
		for(int i = 0; i < depth; i++)
		{
			str += "-";
		}
		str += node.value + "\n";
		str += toStringHelper(node.left, depth + 1);
		return str;
	}

	/**
	 * Overwrite the old file for this gameTree with the current state that may
	 * have new questions added since the game started.
	 *
	 */
	public void saveGame()
	{
		PrintWriter diskFile = null;
		try { 
			diskFile = new PrintWriter(new File(currentFile)); 
		}
		catch (FileNotFoundException e) { 
			System.out.println("Could not create file: " + currentFile); 
		}
		save(diskFile, root);
		diskFile.close();
	}

	public void save(PrintWriter diskFile, Node node)
	{
		diskFile.println(node.value);
		if (node.value.endsWith("?"))
		{
			save(diskFile, node.left);
			save(diskFile, node.right);
		}
	}
}
