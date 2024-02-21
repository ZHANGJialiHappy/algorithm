import java.util.Arrays;
import java.util.Scanner;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Experiment {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniformDouble();
            // a[i] = Math.random();

        }
        Insertion.sort(a);
        // Arrays.sort(a);
        StdOut.println(Arrays.toString(a));

        String[] b = new String[] { "d", "a", "c", "b" };
        Insertion.sort(b);
        StdOut.println(Arrays.toString(b));

        sc.close();

    }
}
