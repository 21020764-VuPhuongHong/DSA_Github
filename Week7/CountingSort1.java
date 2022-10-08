import java.util.ArrayList;
import java.util.List;

public class CountingSort1 {
    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> freq = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            freq.add(0);
        }
        for (int i = 0; i < arr.size(); i++) {
            int index = arr.get(i);
            freq.set(index, freq.get(index) + 1);
        }
        return freq;
    }
}
