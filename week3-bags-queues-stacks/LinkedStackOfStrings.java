import java.util.Stack;

import edu.princeton.cs.algs4.StdIn;

public class LinkedStackOfStrings {
    private Node first = null;

    private class Node {
        private String item;
        private Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String item) {

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;

    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    public String peek() {
        return first.item;
    }

    public static void main(String[] args) {
        LinkedStackOfStrings a = new LinkedStackOfStrings();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) {
                System.out.println(a.pop());
            } else {
                a.push(s);
            }
        }

    }
}