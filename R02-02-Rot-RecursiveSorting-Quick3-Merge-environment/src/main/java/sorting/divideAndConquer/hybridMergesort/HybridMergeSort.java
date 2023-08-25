package sorting.divideAndConquer.hybridMergesort;

import java.util.ArrayList;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;

		if (array.length <= SIZE_LIMIT) {
			INSERTIONSORT_APPLICATIONS++;
			insertionSort(array, leftIndex, rightIndex);
		} else {
			MERGESORT_APPLICATIONS++;
			mergeSort(array, leftIndex, rightIndex);
		}
	}

	public void insertionSort(T[] array, int leftIndex, int rightIndex) {
		if (!(leftIndex >= rightIndex || leftIndex < 0 || rightIndex > array.length || array == null)) {

			for (int i = leftIndex; i < rightIndex + 1; i++) {
				int j = i;
				
				while (j > leftIndex && array[j].compareTo(array[j - 1]) < 0) {
					Util.swap(array, j, j - 1);
					j -= 1;
				}
			}
		}
	}

	private void mergeSort(T[] array, int leftIndex, int rightIndex) {
		if (!(leftIndex >= rightIndex || leftIndex < 0 || rightIndex > array.length || array == null)) {
			int middleIndex = (leftIndex + rightIndex) / 2;

			sort(array, leftIndex, middleIndex);
			sort(array, middleIndex + 1, rightIndex);
			merge(array, leftIndex, middleIndex, rightIndex);
		}
	}

	private void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {
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
