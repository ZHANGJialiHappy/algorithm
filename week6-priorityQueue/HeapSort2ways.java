import java.util.Arrays;

// HeapTopDown: <= 3nlogn compares (and <=2nlogn exchange)
// Heap BottomUp: <=2nlogn +2n compares (and <= nlogn + n exchange)
// Heapsort uses only Θ(1) extra space, no extra space added
public class HeapSort2ways {
    public static void sort(Comparable[] a) {
        int n = a.length;

        // Top-down heap construction: <= logn compares(and exchanges)
        // let all element swim up one by one, so we get first max
        for (int k = 1; k < n; k++)
            swim(a, k);

        // bottom-up heap construction: <= 2n compares(and n exchanges)
        // let all parents sink.
        for (int k = (n - 1) / 2; k >= 1; k--)
            sink(a, k, n - 1);

        // sortdown <= 2nlogn compares(and <= nlogn exchanges)
        int k = n - 1;
        while (k > 1) {
            // change max and last unsorted element,
            // then max become last and unsorted element become 1st.
            exch(a, 1, k--);
            // let 1st element sink, then we get another max.
            sink(a, 1, k);
        }
    }

    private static void sink(Comparable[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(a, j, j + 1))
                j++;
            if (!less(a, k, j))
                break;
            exch(a, k, j);
            k = j;
        }
    }

    private static void swim(Comparable[] a, int k) {
        while (k > 1 && less(a, k / 2, k)) {
            exch(a, k, k / 2);
            k = k / 2;
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        // ! first element will not be sorted
        Integer[] m = { 100, 3, 4, 3, 2 };
        sort(m);
        System.out.println(Arrays.toString(m));
    }

}
