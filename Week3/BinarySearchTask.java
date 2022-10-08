import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

public class BinarySearchTask {
    public static int binarySearch(int[] a, int number) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = a[mid];

            if (midValue < number)
                low = mid + 1;
            else if (midValue > number)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int number = StdIn.readInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = StdIn.readInt();
            //arr[i] = StdRandom.uniformInt(-999999, 999999);
            System.out.print(arr[i] + " ");
        }
        Arrays.sort(arr);
        System.out.print("\n");
        System.out.println(binarySearch(arr, number));
    }
}
