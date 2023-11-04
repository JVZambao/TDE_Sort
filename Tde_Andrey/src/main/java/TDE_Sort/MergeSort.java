package TDE_Sort;

import java.util.Arrays;

public class MergeSort {
    private int comparisons;
    private int swaps;
    private long executionTime;
    private int[] originalArray;
    private int[] sortedArray;
    private int tamanhoArray; // Nova variável para armazenar o tamanho do array

    public void sort(int[] array) {
        originalArray = Arrays.copyOf(array, Tamanho_Array(array)); // Usando a função Tamanho_Array
        long startTime = System.nanoTime();
        mergeSort(array);
        long endTime = System.nanoTime();
        executionTime = endTime - startTime;
        sortedArray = Arrays.copyOf(array, Tamanho_Array(array)); // Usando a função Tamanho_Array
    }

    private int Tamanho_Array(int[] array) {
        int tamanho = 0;
        for (int i : array) {
            tamanho++;
        }
        return tamanho;
    }

    private void mergeSort(int[] array) {
        int n = array.length;
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = array[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    private void merge(int[] array, int[] left, int[] right) {
    int nL = left.length;
    int nR = right.length;
    int i = 0, j = 0, k = 0;

    while (i < nL && j < nR) {
        if (left[i] <= right[j]) {
            array[k] = left[i];
            i++;
        } else {
            array[k] = right[j];
            j++;
        }
        k++;
        comparisons++;
    }

    while (i < nL) {
        array[k] = left[i];
        i++;
        k++;
        swaps++; // Incrementa swaps ao fazer a troca
    }

    while (j < nR) {
        array[k] = right[j];
        j++;
        k++;
        swaps++; // Incrementa swaps ao fazer a troca
    }
}

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public int[] getOriginalArray() {
        return originalArray;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }
}
