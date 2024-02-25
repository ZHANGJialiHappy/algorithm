import java.util.Arrays;

public class Sort {
    // find the smallest one after i, then exchange
    // Selection sort: ~ n2 / 2 compares, n exchanges.
    public static int[] selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a, j, min)) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
        return a;

    }

    // 前后比，Worst case. Insertion sort makes ~ ½ n2 compares and ~ ½ n2 exchanges
    public static int[] insertionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a, j, j - 1)) {
                    exch(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return a;

    }

    // nlogn
    public static int[] mergeSort(int[] a) {
        int[] aux = new int[a.length];
        mergeSort(a, aux, 0, a.length - 1);
        return a;
    }

    private static void mergeSort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, aux, lo, mid);
        mergeSort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux, j, i))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    public static int[] bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (!less(a, j, j + 1)) {
                    exch(a, j, j + 1);
                }
            }
        }
        return a;
    }

    private static boolean less(int[] a, int i, int j) {
        return a[i] - a[j] < 0;
    }

    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 4, 2, 6, 2, 5 };
        // System.out.println(Arrays.toString(selectionSort(a)));
        System.out.println(Arrays.toString(mergeSort(a)));

    }
}