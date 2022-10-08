import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class Sum {
        private static void printPairs(int[] arr)
        {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length - 1; j++) {
                    if (arr[i] + arr[j] == 0) {
                        System.out.println("(" + arr[i] + ", " + arr[j] + ")");
                    }
                }
            }
        }

        private static void printThree(int[] arr)
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
            int[] a = {-10, -8, 5, -7, -2, 1, 3, 4, 5, -3, 9, 8};
            printThree(a);
        }
}
