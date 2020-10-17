import java.util.*;
import java.io.*;

public class Runner {
	public static void main(String[] args) throws FileNotFoundException {
		WordLadder ladder = new WordLadder("./dictionary.txt");
		System.out.println(ladder.findShortestLadder("blue", "pink"));
	}
}
