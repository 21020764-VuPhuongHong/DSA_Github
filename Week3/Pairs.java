import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Pairs {
    public static int pairs(int k, List<Integer> arr) {
        HashMap<Integer, Integer> check = new HashMap<>();
        int count = 0;
        Collections.sort(arr);
        for (Integer element : arr) {
            if (check.get(element - k) != null) {
                count++;
            }
            check.put(element, 1);
        }
        return count;
    }
}
