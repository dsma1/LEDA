package sorting.divideAndConquer;

import java.util.ArrayList;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int middleIndex = (leftIndex + rightIndex) / 2;

			sort(array, leftIndex, middleIndex);
			sort(array, middleIndex + 1, rightIndex);
			merge(array, leftIndex, middleIndex, rightIndex);
		}
	}

	public void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {
		int sizeLeftArray = (middleIndex - leftIndex) + 1;
		int sizeRightArray = rightIndex - middleIndex;

		ArrayList<T> leftArray = new ArrayList<T>();
		ArrayList<T> rightArray = new ArrayList<T>();

		for (int i = 0; i < sizeLeftArray; i++) {
			leftArray.add(i, array[leftIndex + i]);
		}

		for (int j = 0; j < sizeRightArray; j++) {
			rightArray.add(j, array[middleIndex + 1 + j]);
		}

		int index1 = 0;
		int index2 = 0; 
		int position = leftIndex;

		while (index1 < sizeLeftArray && index2 < sizeRightArray) {
			if (leftArray.get(index1).compareTo(rightArray.get(index2)) <= 0) {
				array[position] = leftArray.get(index1);
				index1++;
			} else {
				array[position] = rightArray.get(index2);
				index2++;
			}

			position++;
		}

		while (index1 < sizeLeftArray) {
			array[position] = leftArray.get(index1);
			index1++;
			position++;
		}

		while (index2 < sizeRightArray) {
			array[position] = rightArray.get(index2);
			index2++;
			position++;
		}
	}

}
