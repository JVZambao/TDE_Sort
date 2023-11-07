package TDE_Sort;

public class MergeSort {
    private int comparisons;
    private int swaps;
    private long executionTime;
    private int[] originalArray;
    private int[] sortedArray;
    private int tamanhoArray;

    public void sort(int[] array) {
        tamanhoArray = Tamanho_Array(array);
        originalArray = new int[tamanhoArray];
        Copiar_Array(array, originalArray, tamanhoArray);

        long startTime = System.nanoTime();
        mergeSort(array, 0, tamanhoArray - 1);
        long endTime = System.nanoTime();
        executionTime = endTime - startTime;

        sortedArray = new int[tamanhoArray];
        Copiar_Array(array, sortedArray, tamanhoArray);
    }

    private int Tamanho_Array(int[] array) {
        int tamanho = 0;
        for (int i : array) {
            tamanho++;
        }
        return tamanho;
    }

    private void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    private void merge(int[] array, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        Copiar_Array(array, left, n1, low);
        Copiar_Array(array, right, n2, mid + 1);

        int i = 0, j = 0, k = low;

        while (i < n1 && j < n2) {
            comparisons++;
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
                swaps++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = right[j];
            j++;
            k++;
            swaps++;
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

    private void Copiar_Array(int[] source, int[] destination, int size) {
        for (int i = 0; i < size; i++) {
            destination[i] = source[i];
        }
    }

    private void Copiar_Array(int[] source, int[] destination, int size, int start) {
        for (int i = 0; i < size; i++) {
            destination[i] = source[start + i];
        }
    }
}
