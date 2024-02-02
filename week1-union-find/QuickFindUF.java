import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindUF {
    private int[] id;
    private int count;

    public QuickFindUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        count = 0;
        int pid = id[p];
        count++;
        int qid = id[q];
        count++;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
                count++;
            }
            count++;
        }
        StdOut.println(Arrays.toString(id) + " " + count);
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) == uf.find(q))
                continue;
            uf.union(p, q);
        }
    }
}
