
import java.util.Iterator;
import java.util.StringJoiner;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Rene Argento
 */
public class LikedList<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private int size;
    private Node first;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(Item item) {
        if (isEmpty()) {
            first = new Node();
            first.item = item;
        } else {
            Node current;
            for (current = first; current.next != null; current = current.next)
                ;

            Node newNode = new Node();
            newNode.item = item;
            current.next = newNode;
        }
        size++;
    }

    public void deleteLastNode() {
        if (!isEmpty()) {
            if (size == 1) {
                first = null;
            } else {
                Node current;
                for (current = first; current.next.next != null; current = current.next)
                    ;
                // Node current = first;
                // for (int i = 0; i < size - 2; i++) {
                // current = current.next;
                // }
                current.next = null;
            }

            size--;
        }
    }

    public void delete(int k) {
        if (k > size - 1) {
            return;
        }
        if (k == 0) {
            first = first.next;
        } else {
            Node current = first;
            for (int i = 0; i < k - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;

        }
        size--;
    }

    // ?????????
    public void removeAfter(Node n) {
        if (isEmpty() || n.next == null) {
            return;
        }
        Node current = first;
        for (int i = 0; i < size; i++) {
            if (current == n) {
                n.next = null;
                size = i + 1;
                break;
            }
            current = current.next;
        }
    }

    public void insertAfter(Node x, Node t) {
        if (x.next == null || t.next == null) {
            return;
        }
        t.next = x.next;
        x.next = t;
        size++;
    }

    public int max() {
        if (isEmpty()) {
            return 0;
        }
        int max = (int) first.item;
        Node current;
        for (current = first.next; current != null; current = current.next) {
            if ((int) current.item > max) {
                max = (int) current.item;
            }
        }
        return max;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;

            return item;
        }
    }

    public static void main(String[] args) {
        LikedList<Integer> linkedList = new LikedList<>();
    }
}