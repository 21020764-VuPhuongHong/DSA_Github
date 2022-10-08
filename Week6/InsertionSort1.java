import java.util.List;

public class InsertionSort1 {
    public static void insertionSort1(int n, List<Integer> arr) {
        int rightMost = arr.get(n - 1);
        boolean checkSorted = false;
        for (int i = n - 2; i >= -1; i--) {
            if (i >= 0) {
                if (arr.get(i) > rightMost) {
                    arr.set(i + 1, arr.get(i));
                } else if (arr.get(i) < rightMost) {
                    arr.set(i + 1, rightMost);
                    checkSorted = true;
                }
            } else {
                arr.set(i + 1, rightMost);
            }
            for (int j = 0; j < n; j++) {
                System.out.print(arr.get(j) + " ");
            }
            System.out.print("\n");
            if (checkSorted) {
                break;
            }
        }
    }
}
