import edu.princeton.cs.algs4.*;

import java.util.Scanner;

public class MaxHeap {
    private static MaxPQ<Integer> maxHeap = new MaxPQ<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            maxHeap.insert(sc.nextInt());
        }
    }
}