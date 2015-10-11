package questions;

public class MinHeap {

	private final int minIndex = 1;
	private int[] heap;
	private int size;
	public int maxSize;

	public MinHeap(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		this.heap = new int[this.maxSize + 1];
		heap[0] = Integer.MIN_VALUE;
	}

	public int parent(int pos) {
		return pos / 2;
	}

	public int leftChild(int pos) {
		return pos * 2;
	}

	public int rightChild(int pos) {
		return (pos * 2) + 1;
	}

	public boolean isLeaf(int pos) {
		if (pos >= this.size / 2 && pos <= this.size) {
			return true;
		} else
			return false;
	}

	public void swap(int pos1, int pos2) {
		int temp = this.heap[pos1];
		this.heap[pos1] = this.heap[pos2];
		this.heap[pos2] = temp;
	}

	public void heapify(int pos) {
		if (!isLeaf(pos)) {
			if (this.heap[pos] > this.heap[leftChild(pos)]
					|| this.heap[pos] > this.heap[rightChild(pos)]) {
				if (this.heap[leftChild(pos)] < this.heap[rightChild(pos)]) {
					swap(pos, leftChild(pos));
					heapify(leftChild(pos));
				} else {
					swap(pos, rightChild(pos));
					heapify(rightChild(pos));
				}
			}
		}
	}

	public void insert(int num) {
		this.heap[++this.size] = num;
		int current = this.size;
		while (this.heap[current] < this.heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
		minHeap();
	}
	
	public void minHeap (){
		for (int pos = (this.size / 2); pos >= 1 ; pos--)
        {
            heapify(pos);
        }
	}
	
	public int remove()
    {
        int popped = heap[minIndex];
        heap[minIndex] = heap[size--]; 
        heapify(minIndex);
        return popped;
    }
	
	
	

	public static void main(String[] args) {

		MinHeap minHeap = new MinHeap(15);
        minHeap.insert(0);
        minHeap.insert(9);
        minHeap.insert(1);
        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(7);
        minHeap.insert(3);
        
        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());
        
	}

}
