package main;

import sort.BubbleSort;
import sort.InsertionSort;
import sort.MySort;
import sort.QuickSort;
import sort.SelectionSort;

public class Main {
	public static void main(String[] args) {
		MySort.run(new SelectionSort());
		MySort.run(new BubbleSort());
		MySort.run(new InsertionSort());
		MySort.run(new QuickSort());
	}
}
