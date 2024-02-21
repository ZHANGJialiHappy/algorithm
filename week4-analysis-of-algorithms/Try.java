import java.util.PriorityQueue;

public class Try {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        queue.add(3);
        queue.add(1);
        queue.add(7);
        queue.add(1);
        queue.add(8);
        // Why output is [1, 1, 7, 3, 8] ? The natural order should be 1,1,3,7,8
        System.out.println("Initial PriorityQueue(output 1): " + queue);

        queue.offer(2);
        queue.offer(3);
        queue.offer(6);
        // why output is [1, 1, 2, 3, 8, 7, 3, 6]?
        System.out.println("Priority queue after Insertion(output 2): " + queue);

        PriorityQueue<String> queue2 = new PriorityQueue<String>();

        queue2.add("Welcome");
        queue2.add("To");
        queue2.add("Geeks");
        queue2.add("4");
        queue2.add("Geeks");
        // why output is [4, Geeks, To, Welcome, Geeks]? Because 2nd "Geeks" is
        // duplicated,
        // so it's position not changed?? Then why output 1 2nd "1" position is changed?
        System.out.println("Initial PriorityQueue2 (output 3): " + queue2);

        queue2.offer("The");
        queue2.offer("Priority");
        queue2.offer("Class");
        // I don't understand the oder.
        System.out.println("Priority queue2 after Insertion (output 4): " + queue2);

    }
}
