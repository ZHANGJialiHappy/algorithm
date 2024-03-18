import java.util.PriorityQueue;
import java.util.Scanner;

public class Try {
    public static void main(String[] args) {

        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> s2.compareTo(s1));
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("EXIT")) {
            String cha = sc.next();
            if (cha.equals("*")) {
                pq.remove();
            } else {
                pq.add(cha);
            }
        }
        for (int i = 0; i < pq.size(); i++) {
            System.out.println(pq.remove());
        }
        System.out.println(pq.size());

        // PRIO*R**I*T*Y***QUE***U*E

        // PriorityQueue<Integer> pq2 = new PriorityQueue<>((s1, s2) ->
        // s2.compareTo(s1));
        // pq2.add(5);
        // pq2.add(8);
        // pq2.add(3);
        // pq2.remove();
        // pq2.add(9);
        // pq2.add(2);
        // pq2.add(4);
        // System.out.println(pq2);

    }
}
