import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF {
    private int[] parent; // parent[i] = parent of i
    private int[] size; // size[i] = number of elements in subtree rooted at i
    private int componentNumber; // number of components
    private int count;

    public WeightedQuickUnionUF(int n) {
        componentNumber = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int count() {
        return componentNumber;
    }

    public int find(int p) {
        validate(p);
        while (p != parent[p]) {
            // parent[p] = parent[parent[p]];
            p = parent[p];
            count++;
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    public void union(int p, int q) {
        count = 0;
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
            count++;
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
            count++;
        }
        StdOut.println(Arrays.toString(parent) + " " + count);

        componentNumber--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            uf.union(p, q);
        }
        StdOut.println(uf.count() + " components");
    }

}
