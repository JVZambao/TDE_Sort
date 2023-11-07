package TDE_Sort;

public class BubbleSort {
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
        bubbleSort(array);
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

    private void bubbleSort(int[] array) {
        for (int i = 0; i < tamanhoArray - 1; i++) {
            for (int j = 0; j < tamanhoArray - i - 1; j++) {
                comparisons++;
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swaps++;
                }
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

    private void Copiar_Array(int[] source, int[] destination, int size) {
        for (int i = 0; i < size; i++) {
            destination[i] = source[i];
        }
    }
}
