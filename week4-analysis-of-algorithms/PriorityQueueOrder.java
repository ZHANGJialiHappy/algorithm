import java.util.PriorityQueue;

public class PriorityQueueOrder {
    public static void printQueue(PriorityQueue queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        queue.add(3);
        queue.add(1);
        queue.add(7);
        queue.add(1);
        queue.add(8);
        // printQueue(queue);

        queue.offer(2);
        queue.offer(3);
        queue.offer(6);
        System.out.println("......");
        printQueue(queue);

        PriorityQueue<String> queue2 = new PriorityQueue<String>();

        queue2.add("Welcome");
        queue2.add("To");
        queue2.add("Geeks");
        queue2.add("4");
        queue2.add("Geeks");
        System.out.println("......");
        // printQueue(queue2);

        queue2.offer("The");
        queue2.offer("Priority");
        queue2.offer("Class");
        System.out.println("......");
        printQueue(queue2);

    }
}
