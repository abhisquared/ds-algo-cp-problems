package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MinHeap {
	public static class Heap {
		private int[] heap;
		private int size;
		private int maxsize;

		public Heap(int maxsize) {
			this.maxsize = maxsize;
			this.size = 0;
			heap = new int[this.maxsize];
		}

		public Heap(int[] array) {
			this.maxsize = array.length;
			this.size = array.length;
			this.heap = Arrays.copyOf(array, size);
			for (int i = this.size / 2 - 1; i >= 0; i--) {
				minHeapify(i);
			}
		}

		private int parent(int pos) {
			return (pos - 1) / 2;
		}

		private int leftChild(int pos) {
			return (2 * pos) + 1;
		}

		private int rightChild(int pos) {
			return (2 * pos) + 2;
		}

		private boolean isLeaf(int pos) {
			if (pos > (size / 2) - 1 && pos <= size) {
				return true;
			}
			return false;
		}

		private void swap(int fpos, int spos) {
			int tmp = heap[fpos];
			heap[fpos] = heap[spos];
			heap[spos] = tmp;
		}

		private void minHeapify(int pos) {
			if (isLeaf(pos)) {
				return;
			}
			int lowest = pos;
			if (leftChild(pos) < this.size && heap[lowest] > heap[leftChild(pos)]) {
				lowest = leftChild(pos);
			}
			if (rightChild(pos) < this.size && heap[lowest] > heap[rightChild(pos)]) {
				lowest = rightChild(pos);
			}
			if (lowest != pos) {
				swap(pos, lowest);
				minHeapify(lowest);
			}
		}

		public void insert(int element) {
			heap[size] = element;
			int current = size;
			while (heap[current] > heap[parent(current)]) {
				swap(current, parent(current));
				current = parent(current);
			}
			size++;
		}

		public int extractMin() {
			int popped = heap[0];
			heap[0] = heap[size - 1];
			this.size--;
			minHeapify(0);
			return popped;
		}

		public int size() {
			return this.size;
		}

		public boolean isEmpty() {
			return this.size() == 0;
		}

		public void print() {
			for (int i = 0; i < size / 2; i++) {
				System.out.print("Parent : " + heap[i]);
				if (leftChild(i) < size) {
					System.out.print(" Left Child : " + heap[leftChild(i)]);
				}
				if (rightChild(i) < size) {
					System.out.print(" Right Child : " + heap[rightChild(i)]);
				}
				System.out.println(); // for new line
			}
		}

	}

	public static void main(String[] args) {
		usingPriorityQueue();
		usingArray();
	}

	public static void usingArray() {
		System.out.println("using custom heap");
		int[] array = { 10, 5, 7, 30, 9 };
		MinHeap.Heap minHeap = new MinHeap.Heap(array);
		minHeap.print();
		System.out.println("Head value using peek function: " + minHeap.extractMin());
		System.out.println("Head value using peek function: " + minHeap.extractMin());
		System.out.println("Head value using peek function: " + minHeap.extractMin());
		minHeap.insert(9);
		minHeap.insert(10);
		minHeap.insert(11);
		minHeap.print();
		System.out.println("Head value using peek function: " + minHeap.extractMin());
		System.out.println("Head value using peek function: " + minHeap.extractMin());
	}

	private static void usingPriorityQueue() {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(Comparator.naturalOrder());
		minHeap.add(10);
		minHeap.add(5);
		minHeap.add(7);
		minHeap.add(30);
		System.out.println("Head value using peek function: " + minHeap.peek());
		Iterator<Integer> itr = minHeap.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("poll value using poll function: " + minHeap.poll());
		minHeap.offer(15);
		System.out.println("Head value using peek function: " + minHeap.peek());
		System.out.println("remove value using remove function: " + minHeap.remove());
	}
}