package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		sort(array, 0, array.length - 1);
		return findFloor(array, x, 0, array.length - 1);
	}

	private Integer findFloor(Integer[] array, Integer x, int leftIndex, int rightIndex) {
		if (!(array == null)) {
			int middleIndex = leftIndex + rightIndex / 2;

			if (leftIndex == rightIndex) {
				return array[leftIndex];
			} else if (array[middleIndex] == x) {
				return x;
			} else if (array[middleIndex] < x) {
				findFloor(array, x, middleIndex + 1, rightIndex);
			} else if (array[middleIndex] > x) {
				findFloor(array, x, leftIndex, middleIndex - 1);
			}
		}

		return null;
	}

	private void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (!(array == null || leftIndex < 0 || rightIndex > array.length || leftIndex >= rightIndex)) {
			int pivot = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivot - 1);
			sort(array, pivot + 1, rightIndex);
		}
	}

	private int partition(Integer[] array, int leftIndex, int rightIndex) {

		int middleIndex = (leftIndex + rightIndex) / 2;

		if (array[middleIndex].compareTo(array[leftIndex]) < 0) {
			Util.swap(array, middleIndex, leftIndex);
		}
		if (array[rightIndex].compareTo(array[middleIndex]) < 0) {
			Util.swap(array, middleIndex, rightIndex);
		}
		if (array[rightIndex].compareTo(array[leftIndex]) < 0) {
			Util.swap(array, leftIndex, rightIndex);
		}

		Util.swap(array, middleIndex, rightIndex - 1);

		Integer pivot = array[rightIndex - 1];
		int i = leftIndex - 1;

		for (int j = leftIndex; j < rightIndex - 1; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				i++;
				Util.swap(array, i, j);
			}
		}

		Util.swap(array, rightIndex - 1, i + 1);
		return i + 1;
	}
}
