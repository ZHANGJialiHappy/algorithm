import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionUF {
    private int[] parent;
    private int count;

    public QuickUnionUF(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    public int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
            count++;
        }
        return p;
    }

    public void union(int p, int q) {
        count = 0;
        int rootP = find(p);
        int rootQ = find(q);
        parent[rootP] = rootQ;
        count++;
        StdOut.println(Arrays.toString(parent) + " " + count);
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) != uf.find(q)) {
                uf.union(p, q);
            }
        }

    }
}
