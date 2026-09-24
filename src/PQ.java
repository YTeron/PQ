import java.util.Arrays;
import java.util.NoSuchElementException;

public class PQ {
    private int[] heap;
    private int size;

    public PQ(){
        this.heap = new int[10];
        this.size = 0;
    }
    public void insert(int value) {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
        heap[size] = value;
        siftUp(size);
        size++;
    }
    public void changeKey(int i, int newValue) {
        int old = heap[i];
        heap[i] = newValue;

        if (newValue > old) {
            siftUp(i);
        } else if (newValue < old) {
            siftDown(i);
        }
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (heap[i] == value) return i;
        }
        return -1;
    }
    public int extractMax() {
        if (size == 0) {
            throw new NoSuchElementException("пуст");
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        if (size > 0) {
            siftDown(0);
        }
        return max;
    }
    public Integer peekMax() {
        return size > 0 ? heap[0] : null;
    }
    private void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap[parent] >= heap[i]) break;
            swap(i, parent);
            i = parent;
        }
    }

    private void siftDown(int i) {
        while (true) {
            int left  = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left  < size && heap[left]  > heap[largest]) largest = left;
            if (right < size && heap[right] > heap[largest]) largest = right;

            if (largest == i) break;
            swap(i, largest);
            i = largest;
        }
    }

    private void swap(int a, int b) {
        int t = heap[a];
        heap[a] = heap[b];
        heap[b] = t;
    }

}
