import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;

    private class Node {
        Item data;
        Node next;
    }

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        int size = 0;
        if (!isEmpty()) {
            size++;
            Node p = first;
            while (p.next != null) {
                p = p.next;
                size++;
            }
        }
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node oldFirst = first;
        first = new Node();
        first.data = item;
        first.next = oldFirst;
        if (last == null) {
            last = first;
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node newLast = new Node();
        newLast.data = item;
        if (first != null) {
            last.next = newLast;
            last = newLast;
        } else {
            last = newLast;
            first = newLast;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = first.data;
        first = first.next;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = last.data;
        if (last != first) {
            Node p = first;
            while (p.next.next != null) {
                p = p.next;
            }
            last = p;
            last.next = null;
        } else {
            last = null;
            first = null;
        }
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new Iterator<>() {
            private Node currentNode = null;

            @Override
            public boolean hasNext() {
                return !isEmpty() && currentNode != last;
            }

            @Override
            public Item next() {
                if (currentNode == null) {
                    currentNode = first;
                    return currentNode.data;
                }
                if (currentNode.next == null) {
                    throw new NoSuchElementException();
                }
                currentNode = currentNode.next;
                return currentNode.data;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> test = new Deque<>();

        if (test.isEmpty()) {
            System.out.println("empty!");
        }
        System.out.println(test.size());

        test.addLast("hic");
        test.addLast("hello");
        test.addFirst("hi");
        test.addFirst("hmm");
        test.addLast("smile");
        test.addLast("bye");

        // it.remove();

        System.out.println(test.removeLast());
        System.out.println(test.removeFirst());
        System.out.println(test.removeLast());
        System.out.println(test.removeFirst());
        test.addLast("end");
        test.addFirst("haha");
        System.out.println(test.removeFirst());

        System.out.println(test.size());

        Iterator<String> it = test.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.print("\n");
    }
}
