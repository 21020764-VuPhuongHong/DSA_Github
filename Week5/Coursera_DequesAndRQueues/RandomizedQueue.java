import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] queue;
    private int last;

    // construct an empty randomized queue
    public RandomizedQueue() {
        queue = (Item[]) new Object[1];
        last = 0;
    }

    private void resize(int newSize) {
        Item[] copy = (Item[]) new Object[newSize];
        for (int i = 0; i < last; i++) {
            copy[i] = queue[i];
        }
        queue = copy;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return last == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return last;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (last == queue.length) {
            resize(queue.length * 2);
        }
        queue[last++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (last <= queue.length / 4) {
            resize(queue.length / 2);
        }
        int index = StdRandom.uniformInt(0, last);
        Item randomValue = queue[index];
        queue[index] = queue[--last];
        queue[last] = null;

        return randomValue;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue[StdRandom.uniformInt(0, last)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new Iterator<>() {
            private int currentIndex = 0;
            private Item[] copy = (Item[]) new Object[last];

            private void shuffle(Item[] arr) {
                for (int i = 0; i < arr.length; i++) {
                    int randomIndex = StdRandom.uniformInt(i, arr.length);
                    Item temp = arr[i];
                    arr[i] = arr[randomIndex];
                    arr[randomIndex] = temp;
                }
            }

            private Item[] shuffleArray() {
                for (int i = 0; i < last; i++) {
                    copy[i] = queue[i];
                }
                shuffle(copy);
                return copy;
            }

            private Item[] shuffledArray = shuffleArray();

            @Override
            public boolean hasNext() {
                return currentIndex < last;
            }

            @Override
            public Item next() {
                if (isEmpty()) {
                    throw new NoSuchElementException();
                }
                return shuffledArray[currentIndex++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> test = new RandomizedQueue<>();
        System.out.println(test.isEmpty());
        test.enqueue(1);
        test.enqueue(10);
        test.enqueue(100);
        test.enqueue(9999);
        System.out.println(test.dequeue());
        System.out.println(test.size());
        System.out.println(test.sample());

        Iterator<Integer> it = test.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.print("\n");
    }
}
