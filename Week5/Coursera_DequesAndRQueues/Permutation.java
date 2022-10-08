import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rQueue = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            rQueue.enqueue(item);
            if (item.equals("!")) {
                break;
            }
        }
        Iterator<String> it = rQueue.iterator();
        for (int i = 0; i < k; i++) {
            if (it.hasNext()) {
                StdOut.println(it.next());
            }
        }
    }
}
