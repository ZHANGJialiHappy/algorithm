import java.util.Map;
import java.util.PriorityQueue;

public class PriorityQueueStack {
    private PriorityQueue<Map.Entry<String, Integer>> pq;
    private int index;

    public PriorityQueueStack() {
        pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        index = 0;
    }

    public void push(String s) {
        pq.add(Map.entry(s, index++));
    }

    public String pop() {
        return pq.poll().getKey();
    }

    public static void main(String[] args) {
        PriorityQueueStack a = new PriorityQueueStack();
        a.push("a");
        a.push("b");
        System.out.println(a.pop());
    }
}
