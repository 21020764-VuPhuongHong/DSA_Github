import java.util.*;

public class NewPairs {
    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        Hashtable<Integer, Integer> check = new Hashtable<>();
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