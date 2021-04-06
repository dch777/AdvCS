import java.util.*;
import java.io.*; 

class Node implements Comparable<Node> {

	public int weight;
	public Node left, right;
	public int c;

	public Node(int weight, int c) {
		this.weight = weight;
		this.c = c;
	}
	
	public Node(Node left, Node right) {
		this.c = -1;
		this.left = left;
		this.right = right;
		this.weight = left.weight + right.weight;
	}

	@Override
	public String toString() {
		return Character.toString((char) c);
	}

	@Override
	public int compareTo(Node node) {
		if(this.weight == node.weight)  
			return 0;  
		else if(this.weight > node.weight)  
			return 1;  
	   	else  
			return -1;  
	}
}

public class HuffmanTree {

	private Node root;

	public HuffmanTree(int[] count) {
		PriorityQueue<Node> tree = new PriorityQueue<Node>();
		for (char c = 0; c < count.length; c++) {
			if (count[c] > 0) {
				tree.add(new Node(count[c], c));
			}
		}
		tree.add(new Node(0, 256));

		while (tree.size() > 1) {
			tree.add(new Node(tree.poll(), tree.poll()));
		}
		root = tree.poll();
	}

	public HuffmanTree(String codeFile) throws FileNotFoundException {
		Scanner file = new Scanner(new File(codeFile));
		Node curr, prev;
		root = new Node(0, -1);
		while (file.hasNextLine()) {
			int n = Integer.parseInt(file.nextLine());
			String code = file.nextLine();

			prev = root;
			for (int i = 0; i < code.length(); i++) {
				char ch = code.charAt(i);
				if (ch == '0') {
					if (prev.left == null) {
						if (i == code.length() - 1) {
							curr = new Node(0, (char) n);
						} else {
							curr = new Node(0, -1);
						}
						prev.left = curr;
					} else {
						curr = prev.left;
					}
				} else {
					if (prev.left == null) {
						if (i == code.length() - 1) {
							curr = new Node(0, (char) n);
						} else {
							curr = new Node(0, -1);
						}
						prev.left = curr;
					} else {
						curr = prev.left;
					}
				}
				prev = curr;
			}
		}
	}

	public Node getRoot() {
		return root;
	}

	public void write(String fileName) throws FileNotFoundException {
		PrintStream output = new PrintStream(new File(fileName));
		write(output, this.root, "");
	}

	private void write(PrintStream output, Node node, String path) {
		if (node.left == null && node.right == null) {
			output.println(node.c);
			output.println(path);
		} else {
			write(output, node.left, path+0);
			write(output, node.right, path+1);
		}
	}

	public void encode(String codeFile, String inFile, String outFile) throws IOException {
		Scanner file = new Scanner(new File(codeFile));
		BitOutputStream output = new BitOutputStream(outFile);
		FileInputStream input = new FileInputStream(new File(inFile));

		HashMap<Integer, String> charMap = new HashMap<Integer, String>();
		while (file.hasNextLine()) {
			int n = Integer.parseInt(file.nextLine());
			String code = file.nextLine();
			charMap.put(n, code);
		}

		int c = input.read();
		while (c != -1) {
			for (int i = 0; i < charMap.get(c).length(); i++) {
				output.writeBit(Integer.parseInt("" + charMap.get(c).charAt(i)));
			}
			c = input.read();
		}
	}

	public void decode(BitInputStream in, String outFile) throws FileNotFoundException {
		PrintStream output = new PrintStream(new File(outFile));
		int n;
		String s = "";
		while (true) {
			n = readBits(in);
			if (n < 256) {
				s += (char) n;
			} else {
				break;
			}
		}
		output.print(s);
	}

	private int readBits(BitInputStream input) {
		Node tmp = this.root;
		while (true) {
			int bit = input.readBit();
			if (bit == 0) {
				tmp = tmp.left;
			} else {
				tmp = tmp.right;
			}
		}
	}

	public void printTree() {
		TreePrinter.printTree(this.root);
	}
}
