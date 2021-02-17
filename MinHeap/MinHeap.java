import java.util.*;

public class MinHeap {

	private Integer[] heap;
	private int size = 0;
	static final int DEFAULT_CAPACITY = 8;

	public MinHeap() {
		heap = new Integer[DEFAULT_CAPACITY + 1];
	}

	public MinHeap(int capacity) {
		heap = new Integer[capacity + 1];
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int peekMinimum() {
		return heap[1];
	}

	public int getLeftChildIndex(int index) {
		return (2 * index);
	}

	public int getRightChildIndex(int index) {
		return (2 * index) + 1;
	}

	public int getParentIndex(int index) {
		return index / 2;
	}

	private void doubleCapacity() {
		Integer[] tmp = heap.clone();
		heap = new Integer[heap.length * 2];
		System.arraycopy(tmp, 0, heap, 0, tmp.length);
	}

	public void insert(int value) {
		if (size + 1 >= heap.length)
			doubleCapacity();
		size++;
		heap[size] = value;
		bubbleUp(size);
	}

	private void bubbleUp(int index) {
		if (index > 1) {
			int parentIndex = getParentIndex(index);
			int parent = heap[parentIndex];
			int current = heap[index];
			if (current < parent) {
				heap[index] = parent;
				heap[parentIndex] = current;
				bubbleUp(parentIndex);
			}
		}
	}

	public int popMinimum() {
		int minimum = heap[1];
		heap[1] = heap[size];
		size--;
		siftDown(1);
		return minimum;
	}

	private void siftDown(int index) {
		if (index > size) {
			return;
		}
		int leftIndex = getLeftChildIndex(index);
		int rightIndex = getRightChildIndex(index);
		if (heap[rightIndex] == null || heap[leftIndex] < heap[rightIndex]) {
			if (heap[index] > heap[leftIndex]) {
				int tmp = heap[index];
				heap[index] = heap[leftIndex];
				heap[leftIndex] = tmp;
				siftDown(leftIndex);
			}
		} else {
			if (heap[index] > heap[rightIndex]) {
				int tmp = heap[index];
				heap[index] = heap[rightIndex];
				heap[rightIndex] = tmp;
				siftDown(rightIndex);
			}
		}
	}

	@Override
    public String toString()
    {
        String output = "";

        for (int i = 1; i <= getSize(); i++) 
            output += heap[i] + ", ";

        return output.substring(0, output.lastIndexOf(",")); //lazily truncate last comma
    }

    /** method borrowed with minor modifications from the internet somewhere, for printing */
    public void display() {
        int nBlanks = 32, itemsPerRow = 1, column = 0, j = 1;
        String dots = "...............................";
        System.out.println(dots + dots);      
        while (j <= this.getSize())
        {
            if (column == 0)                 
                for (int k = 0; k < nBlanks; k++)
                    System.out.print(' ');

            System.out.print((heap[j] == null)? "" : heap[j]);
            
            if (++column == itemsPerRow) {
                nBlanks /= 2;                 
                itemsPerRow *= 2;             
                column = 0;                   
                System.out.println();         
            }
            else                             
                for (int k = 0; k < nBlanks * 2 - 2; k++)
                    System.out.print(' ');
            
            j++;
        }
        System.out.println("\n" + dots + dots); 
    }    
}
