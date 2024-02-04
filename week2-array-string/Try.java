import java.util.Arrays;

import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.StdOut;

public class Try {
    public static void main(String[] args) {
        Alphabet c = new Alphabet("123456789asdfghj");
        char c1 = c.toChar(0);
        char c3 = c.toChar(1);

        int c2 = c.R();
        int[] c4 = c.toIndices("123");
        int c5 = c.lgR();
        // ??

        String c7 = c.toChars(new int[] { 0, 1 });

        StdOut.println("toChar: print several characters: " + new StringBuilder().append(c1).append(c3));
        StdOut.println("print several characters: " + new String(new char[] { c1, c3 }));
        StdOut.println(".........");
        StdOut.println("R(): c's radix is " + c2);
        StdOut.println("lgR(): " + c5);

        StdOut.println("toIndices(): array with related index " + Arrays.toString(c4));
        StdOut.println("return String " + c7);
    }
}
