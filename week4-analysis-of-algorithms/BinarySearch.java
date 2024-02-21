public class BinarySearch {
    // lgN
    public static int binarySearch(int[] a, int key) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                if (lo == hi) {
                    return hi;
                }
                hi = mid;

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 2, 2, 2, 4, 5, 6 };
        System.out.println(binarySearch(a, 2));
    }

}
