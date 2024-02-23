public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] a;
    private int n;

    public MaxPQ(int capacity) {
        a = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    // log n
    public void insert(Key key) {
        a[++n] = key;
        swim(n);
    }

    // log n
    public Key delMax() {
        Key max = a[1];
        exch(1, n--);
        sink(1);
        a[n + 1] = null;
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {

        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1))
                j++;
            if (!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        MaxPQ<String> a = new MaxPQ<>(5);
        a.insert("a");
        a.insert("b");
        a.insert("c");
        a.insert("d");
        a.insert("e");
        while (!a.isEmpty()) {
            System.out.println(a.delMax());
        }
    }
}