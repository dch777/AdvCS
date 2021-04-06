import java.io.*;
import java.util.*;

public class HuffmanCompressor {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        System.out.print("input file name (without extension)? ");
        String inFile = console.nextLine();

		compress(inFile);
		expand(inFile);
    }

	public static void compress(String filename) throws IOException {
        FileInputStream input = new FileInputStream(filename + ".txt");
        int[] count = new int[256];
        int n = input.read();
        while (n != -1) {
            count[n]++;
            n = input.read();
        }

        HuffmanTree t = new HuffmanTree(count);
		t.printTree();
		t.write(filename + ".code");
		t.encode(filename + ".code", filename + ".txt", filename + ".short");
	}

	public static void expand(String filename) throws IOException {
		HuffmanTree t = new HuffmanTree(filename + ".code");
		t.decode(new BitInputStream(filename + ".short"), filename + ".new");
	}
}
