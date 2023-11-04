package TDE_Sort;

import java.util.Arrays;

import java.util.Arrays;

public class BubbleSort {
    private int comparisons;
    private int swaps;
    private long executionTime;
    private int[] originalArray;
    private int[] sortedArray;
    private int tamanhoArray; // Nova variável para armazenar o tamanho do array

    public void sort(int[] array) {
        originalArray = Arrays.copyOf(array, Tamanho_Array(array)); // Usando a função Tamanho_Array
        long startTime = System.nanoTime();
        bubbleSort(array);
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

    private void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Troca os elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swaps++;
                }
                comparisons++;
            }

           
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

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);

        System.out.println("Array desordenado:");
        for (int value : bubbleSort.getOriginalArray()) {
            System.out.print(value + " ");
        }

        System.out.println("\nArray ordenado:");
        for (int value : bubbleSort.getSortedArray()) {
            System.out.print(value + " ");
        }

        System.out.println("\nComparisons: " + bubbleSort.getComparisons());
        System.out.println("Swaps: " + bubbleSort.getSwaps());
        System.out.println("Execution Time (ns): " + bubbleSort.getExecutionTime());
    }
}
