import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SherlockAndArray {
    public static String balancedSums(List<Integer> arr) {
        int mid = arr.size() / 2;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < mid; i++) {
            sum1 += arr.get(i);
        }
        for (int i = arr.size() - 1; i > mid; i--) {
            sum2 += arr.get(i);
        }

        if (sum1 == sum2) {
            return "YES";
        } else {
            int mid2 = mid;
            int sum11 = sum1;
            int sum22 = sum2;
            while (mid2 < arr.size() - 1) {
                sum11 += arr.get(mid2);
                sum22 -= arr.get(mid2 + 1);
                mid2++;
                if (sum11 == sum22) {
                    return "YES";
                }
            }

            while (mid > 0) {
                sum1 -= arr.get(mid - 1);
                sum2 += arr.get(mid);
                mid--;
                if (sum1 == sum2) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(input.nextInt());
        }
        System.out.println(balancedSums(arr));
    }
}
