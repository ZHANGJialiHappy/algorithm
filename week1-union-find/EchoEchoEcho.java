import edu.princeton.cs.algs4.UF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EchoEchoEcho {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        UF uf = new UF(n);
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            if (uf.find(v) != uf.find(w)) {
                uf.union(v, w);
                StdOut.println(v + " " + w);
            }
        }
    }
}
