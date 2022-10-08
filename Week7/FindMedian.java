import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindMedian {
    public static int Partition(List<Integer> arr, int low, int high) {
        int i = low;
        int j = high + 1;
        int temp;
        while (true) {
            while (arr.get(++i) < arr.get(low)) {
                if (i == high) {
                    break;
                }
            }

            while (arr.get(low) < arr.get(--j)) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }

        temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);

        return j;
    }
    public static int findMedian(List<Integer> arr) {
        int low = 0;
        int high = arr.size() - 1;
        int j = Partition(arr, low, high);

        while (j != arr.size() / 2) {
            if (j < arr.size() / 2) {
                low = j + 1;
                j = Partition(arr, low, high);
            } else if (j > arr.size() / 2) {
                high = j - 1;
                j = Partition(arr, low, high);
            }
        }
        return arr.get(j);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        System.out.println(findMedian(arr));
    }
}
