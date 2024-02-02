import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DisjointSet {
    private int[] parent;
    private int[] size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int s) {
        validate(s);
        while (s != parent[s]) {
            parent[s] = parent[parent[s]];
            s = parent[s];
        }
        return s;
    }

    public void query(int s, int t) {
        if (find(s) == find(t)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    private void validate(int s) {
        int n = parent.length;
        if (s < 0 || s >= n) {
            throw new IllegalArgumentException("index " + s + " is not between 0 and " + (n - 1));
        }
    }

    public void union(int s, int t) {
        int rootS = find(s);
        int rootT = find(t);
        if (rootS == rootT) {
            return;
        }
        if (size[rootS] < size[rootT]) {
            parent[rootS] = rootT;
            size[rootT] += size[rootS];
        } else {
            parent[rootT] = rootS;
            size[rootS] += size[rootT];
        }
        // StdOut.println(Arrays.toString(parent));
    }

    public void move(int s, int t) {
        int rootS = find(s);
        int rootT = find(t);
        if (rootS == rootT) {
            return;
        }
        parent[s] = rootT;
        // StdOut.println(Arrays.toString(parent));
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int m = StdIn.readInt();

        DisjointSet uf = new DisjointSet(n);
        for (int i = 0; i < m; i++) {
            int f = StdIn.readInt();
            int s = StdIn.readInt();
            int t = StdIn.readInt();
            if (f == 0) {
                uf.query(s, t);
            }
            if (f == 1) {
                uf.union(s, t);
            }
            if (f == 2) {
                uf.move(s, t);
            }
        }
    }

}
