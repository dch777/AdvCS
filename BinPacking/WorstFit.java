import java.util.*;
import java.io.*;

public class WorstFit {

	private static Queue<Disk> disks = new PriorityQueue<Disk>();
	private static int id = 0;

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Enter filename for list of files");
		String fileName = console.nextLine();

		Scanner fileScanner;
		try {
			fileScanner = new Scanner(new File(fileName));
		} catch(Exception e) {
			System.out.println("Invalid filename");
			return;
		}

		ArrayList<Integer> files = new ArrayList<Integer>();
		double total = 0;

		while (fileScanner.hasNextInt()) {
			int file = fileScanner.nextInt();
			files.add(file);
			total += file;
		}

		Collections.sort(files, Collections.reverseOrder());

		for (int file : files) {
			worstFitHelper(file);
		}

		System.out.println("Total size = " + (total / 1000000) + " GB");
		System.out.println("Disks req'd = " + disks.size());
		int i = 0;
		while (!disks.isEmpty()) {
			System.out.println("\t" + disks.peek().getID() + ": " + disks.peek().getRemainingSpace() + " " + disks.poll());
			i++;
		}
	}

	private static void worstFitHelper(int file) {
		if (disks.size() == 0) {
			disks.add(new Disk(id, file));
			id++;
		} else if (disks.peek().getRemainingSpace() < file) {
			Disk tmp = disks.poll();
			worstFitHelper(file);
			disks.add(tmp);
		} else {
			disks.peek().add(file);
			disks.add(disks.poll());
		}
	}
}
