package practice.sort;

public class SortMain {
	public static void main(String[] args) {
		MySort.run(new SelectionSort());
		MySort.run(new BubbleSort());
		MySort.run(new InsertionSort());
		MySort.run(new QuickSort());
		MySort.run(new MergeSort());
		MySort.run(new HeapSort());
		MySort.run(new CountingSort());
	}
}
