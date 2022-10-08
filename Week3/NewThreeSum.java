import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

public class NewThreeSum {
    private static void threeSum(int[] arr)
    {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                if (arr[j] + arr[k] == -arr[i]) {
                    System.out.println("(" + arr[i] + ", " + arr[j] + ", " + arr[k] + ")");
                    j++;
                    k--;
                } else if (arr[j] + arr[k] < -arr[i]) {
                    j++;
                } else {
                    k--;
                }
            }
        }
    }

    public static void main(String[] args) {
        //In in = new In("F:\\LIB\\Coursera\\algs4-data\\4Kints.txt");
        //int[] a = in.readAllInts();
        int n = StdIn.readInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = StdIn.readInt();
            //arr[i] = StdRandom.uniformInt(-999999, 999999);
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
        threeSum(arr);
    }
}
