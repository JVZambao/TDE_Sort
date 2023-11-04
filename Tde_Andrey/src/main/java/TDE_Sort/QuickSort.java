package TDE_Sort;

import java.util.Arrays;

public class QuickSort {
    private int comparisons;
    private int swaps;
    private long executionTime;
    private int[] originalArray;
    private int[] sortedArray;
    private int tamanhoArray; // Nova variável para armazenar o tamanho do array

    public void sort(int[] array) {
        originalArray = Arrays.copyOf(array, Tamanho_Array(array)); // Usando a função Tamanho_Array
        long startTime = System.nanoTime();
        quickSort(array, 0, Tamanho_Array(array) - 1); // Usando a função Tamanho_Array
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

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);

            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                swaps++;
            }
            comparisons++;
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        swaps++;

        return i + 1;
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
