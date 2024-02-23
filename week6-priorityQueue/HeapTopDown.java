import java.util.Arrays;

public class HeapTopDown {
    public static void sort(Comparable[] a) {
        // let all element swim up one by one, so we get first max
        int n = a.length;
        for (int k = 1; k < n; k++)
            swim(a, k);
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
        Integer[] m = { 100, 5, 4, 3, 2 };
        sort(m);
        System.out.println(Arrays.toString(m));
    }

}
