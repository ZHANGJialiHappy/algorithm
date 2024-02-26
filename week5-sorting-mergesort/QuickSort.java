import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(array, low, high);
        sort(array, low, pivot - 1);
        sort(array, pivot + 1, high);
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = { 5, 2, 9, 1, 5, 6 };
        System.out.println("Original array: " + Arrays.toString(array));
        quickSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
