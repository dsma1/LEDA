package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (!(array == null || leftIndex < 0 || rightIndex <= leftIndex || rightIndex < 0)) {

			int maxElement = 0;
			int minElement = array[leftIndex];

			for (int element : array) {
				if (element < minElement) {
					minElement = element;
				}

				if (element > maxElement) {
					maxElement = element;
				}
			}

			int sizeCountArray = maxElement - minElement + 1;
			int sizeOriginalArray = rightIndex - leftIndex + 1;
			Integer[] countArray = new Integer[sizeCountArray];

			for (int i = 0; i < sizeOriginalArray; i++) {
				countArray[array[i] - minElement]++;
			}

			for (int j = 1; j <= sizeCountArray; j++) {
				countArray[j] = countArray[j] + countArray[j - 1];
			}

			Integer[] sortedArray = new Integer[sizeOriginalArray];

			for (int k = sizeOriginalArray - 1; k > 0; k--) {
				sortedArray[countArray[array[k] - minElement]] = array[k];
				countArray[array[k] - minElement]--;
			}

			array = sortedArray;

		}
	}
}
