import java.util.*;

public class Disk implements Comparable<Disk> {

	private int[] files;
	private int remainingSpace;
	private int id;

	public Disk(int id, int... files) {
		this.id = id;
		this.files = files;
		int sum = 0;
		for (int file : files) {
			sum += file;
		}
		this.remainingSpace = 1000000 - sum;
	}

	public int getRemainingSpace() {
		return remainingSpace;
	}

	public int getID() {
		return id;
	}

	public void add(int newFile) {
		files = Arrays.copyOf(files, files.length + 1);
		files[files.length - 1] = newFile;
		int sum = 0;
		for (int file : files) {
			sum += file;
		}
		this.remainingSpace = 1000000 - sum;
	}

	@Override
	public String toString() {
		return Arrays.toString(files);
	}

	@Override
	public int compareTo(Disk disk) {
		if (remainingSpace == disk.getRemainingSpace()) {
			return 0;
		} else if (remainingSpace < disk.getRemainingSpace()) {
			return 1;
		} else {
			return -1;
		}
	}
}
