import java.util.*;

public class Word implements Comparable<Word> {

	String word;
	private int g;
	private int h;
	private int f;
	private Word parent;

	public Word(String word, int g, int h) {
		this.word = word;
		this.g = g;
		this.h = h;
		this.f = g + h;
		this.parent = null;
	}

	public Word(String word, int g, int h, Word parent) {
		this.word = word;
		this.g = g;
		this.h = h;
		this.f = g + h;
		this.parent = parent;
	}

	public int getG() {
		return g;
	}

	public int getH() {
		return h;
	}

	public int getF() {
		return f;
	}

	public Word getParent() {
		return parent;
	}

	public String toString() {
		return word;
	}

	@Override
	public int compareTo(Word other) {
		return Integer.compare(this.f, other.getF());
	}
}
