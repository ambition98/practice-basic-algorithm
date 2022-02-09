package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import sort.BubbleSort;
import sort.HeapSort;
import sort.InsertionSort;
import sort.MergeSort;
import sort.MySort;
import sort.QuickSort;
import sort.SelectionSort;

public class Main {
	public static void main(String[] args) {
//		MySort.run(new SelectionSort());
//		MySort.run(new BubbleSort());
//		MySort.run(new InsertionSort());
//		MySort.run(new QuickSort());
//		MySort.run(new MergeSort());
		MySort.run(new HeapSort());
	}
}
