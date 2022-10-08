import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestNumbers {
    public static List<Integer> closestNumbers(List<Integer> arr) {
        List<Integer> closestNumbers = new ArrayList<>();
        Collections.sort(arr);
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
}
