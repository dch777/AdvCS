import java.util.*;
import java.io.*;

public class WordLadder {

	private String first;
	private String last;
	private Queue<Word> frontier = new PriorityQueue<Word>();
	private Queue<Word> visited = new LinkedList<Word>();
	private Stack<String> ladder = new Stack<String>();
	private String dictionaryPath;

	public WordLadder(String dictionaryPath) throws FileNotFoundException {
		this.dictionaryPath = dictionaryPath;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	public String toString() {
		return ladder.toString();
	}

	private boolean isValidChild(Word parent, String child) {
		if (parent.toString().equals(child))
			return false;
		if (parent.toString().length() != child.length())
			return false;

		int totalDifferent = 0;
		for (int i = 0; i < parent.toString().length(); i++) {
			if (parent.toString().charAt(i) != child.charAt(i)) {
				totalDifferent++;
				if (totalDifferent > 1) {
					return false;
				}
			}
		}

		for (Word word : frontier) {
			if (child.equals(word.toString()) && word.getG() <= parent.getG() + 1) {
				return false;
			}
		}
		for (Word word : visited) {
			if (child.equals(word.toString()) && word.getG() <= parent.getG() + 1) {
				return false;
			}
		}

		return true;
	}

	private int heuristic(String initial, String goal) {
		int totalDifferent = 0;
		for (int i = 0; i < initial.length(); i++) {
			if (initial.charAt(i) != goal.charAt(i)) {
				totalDifferent++;
			}
		}

		return totalDifferent;
	}

	private void getChildren(Word word) {
		Scanner dictionary;
		try {
			dictionary = new Scanner(new File(dictionaryPath));
		} catch(Exception e){
			dictionary = null;
			e.printStackTrace();
		}
		while (dictionary.hasNext()) {
			String child = dictionary.next().toLowerCase();
			if (isValidChild(word, child)) {
				frontier.offer(new Word(child, word.getG() + 1, heuristic(child, last), word));
			}
		}
	}

	public Stack<String> findShortestLadder(String first, String last) {
		this.first = first;
		this.last = last;
		Word initial = new Word(first, 0, heuristic(first, last));
		getChildren(initial);
		Word currentWord = initial;
		do {
			getChildren(currentWord);
			visited.offer(currentWord);
			currentWord = frontier.poll();
		} while (!last.equals(currentWord.toString()));

		Stack<String> tmp = new Stack<String>();
		while (currentWord.getParent() != null) {
			tmp.push(currentWord.toString());
			currentWord = currentWord.getParent();
		}
		tmp.push(initial.toString());

		while (!tmp.isEmpty()) {
			ladder.push(tmp.pop());
		}
		return ladder;
	}
}
