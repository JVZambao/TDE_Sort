package TDE_Sort;

public class QuickSort {
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
        quickSort(array, 0, tamanhoArray - 1);
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

    private void Copiar_Array(int[] source, int[] destination, int size) {
        for (int i = 0; i < size; i++) {
            destination[i] = source[i];
        }
    }
}
