import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import TDE_Sort.BubbleSort;
import TDE_Sort.MergeSort;
import TDE_Sort.QuickSort;


public class SortingPerformanceAnalyzer {
    public static void main(String[] args) {
        //Trocar o tamanho do vetor entre (50, 500, 1000, 5000 e 10000)
        int[] randomNumbers = generateRandomArray(10000, 1, 999);
        QuickSort quickSort = new QuickSort();
        MergeSort mergeSort = new MergeSort();
        BubbleSort bubbleSort = new BubbleSort();

        // Copia a mesma lista desordenada para as três classes
        int[] randomNumbersCopy = Arrays.copyOf(randomNumbers, randomNumbers.length);
        quickSort.sort(randomNumbersCopy);
        mergeSort.sort(Arrays.copyOf(randomNumbers, randomNumbers.length));
        bubbleSort.sort(Arrays.copyOf(randomNumbers, randomNumbers.length));

        try {
            FileWriter csvWriter = new FileWriter("sorting_performance.csv");
            csvWriter.append("Algorithm,Time (ns),Comparisons,Swaps,Original List,Sorted List\n");
            writePerformanceData(csvWriter, "QuickSort", quickSort);
            writePerformanceData(csvWriter, "MergeSort", mergeSort);
            writePerformanceData(csvWriter, "BubbleSort", bubbleSort);
            csvWriter.close();
            System.out.println("Performance data written to sorting_performance.csv");
        } catch (IOException e) {
        }
    }

    private static int[] generateRandomArray(int size, int minValue, int maxValue) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }
        return array;
    }

    private static void writePerformanceData(FileWriter writer, String algorithm, BubbleSort sortingAlgorithm) throws IOException {
        writer.append(algorithm + ",");
        writer.append(Long.toString(sortingAlgorithm.getExecutionTime()) + ",");
        writer.append(Integer.toString(sortingAlgorithm.getComparisons()) + ",");
        writer.append(Integer.toString(sortingAlgorithm.getSwaps()) + ",");
        writer.append(Arrays.toString(sortingAlgorithm.getOriginalArray()) + ",");
        writer.append(Arrays.toString(sortingAlgorithm.getSortedArray()) + "\n");
    }
    private static void writePerformanceData(FileWriter writer, String algorithm, MergeSort sortingAlgorithm) throws IOException {
        writer.append(algorithm + ",");
        writer.append(Long.toString(sortingAlgorithm.getExecutionTime()) + ",");
        writer.append(Integer.toString(sortingAlgorithm.getComparisons()) + ",");
        writer.append(Integer.toString(sortingAlgorithm.getSwaps()) + ",");
        writer.append(Arrays.toString(sortingAlgorithm.getOriginalArray()) + ",");
        writer.append(Arrays.toString(sortingAlgorithm.getSortedArray()) + "\n");
    }
    private static void writePerformanceData(FileWriter writer, String algorithm, QuickSort sortingAlgorithm) throws IOException {
        writer.append(algorithm + ",");
        writer.append(Long.toString(sortingAlgorithm.getExecutionTime()) + ",");
        writer.append(Integer.toString(sortingAlgorithm.getComparisons()) + ",");
        writer.append(Integer.toString(sortingAlgorithm.getSwaps()) + ",");
        writer.append(Arrays.toString(sortingAlgorithm.getOriginalArray()) + ",");
        writer.append(Arrays.toString(sortingAlgorithm.getSortedArray()) + "\n");
    }
    
}
