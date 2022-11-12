import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewClosestNumbers {
    private static void merge(List<Integer> src, List<Integer> dst, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                dst.set(k, src.get(j++));
            } else if (j > hi) {
                dst.set(k, src.get(i++));
            } else if (src.get(j) < src.get(i)) {
                dst.set(k, src.get(j++));
            } else {
                dst.set(k, src.get(i++));
            }
        }
    }

    public static void sort(List<Integer> src, List<Integer> dst, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(dst, src, lo, mid);
        sort(dst, src, mid + 1, hi);

        if (src.get(mid + 1) >= src.get(mid)) {
            for (int i = lo; i <= hi; i++) {
                dst.set(i, src.get(i));
            }
            return;
        }

        merge(src, dst, lo, mid, hi);
    }

    public static List<Integer> closestNumbers(List<Integer> arr) {
        List<Integer> closestNumbers = new ArrayList<>();
        List<Integer> arrCopy = new ArrayList<>(arr);
        sort(arrCopy, arr, 0, arr.size() - 1);
        int min = arr.get(1) - arr.get(0);
        for (int i = 2; i < arr.size(); i++) {
            min = Math.min(arr.get(i) - arr.get(i - 1), min);
        }
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) - arr.get(i - 1) == min) {
                closestNumbers.add(arr.get(i - 1));
                closestNumbers.add(arr.get(i));
            }
        }
        return closestNumbers;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scan.nextInt());
        }
        List<Integer> closestNums = closestNumbers(arr);
        for (Integer i : closestNums) {
            System.out.print(i + " ");
        }
        scan.close();
    }
}
