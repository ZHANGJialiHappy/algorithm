import java.util.Arrays;

public class ReserveArray {
    public static int[] reserve(int[] a) {
        int temp = 0;
        for (int i = 0; i < a.length / 2; i++) {
            temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reserve(new int[] { 1, 2, 3, 4 })));
    }

}
