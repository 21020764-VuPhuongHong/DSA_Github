import java.util.ArrayList;
import java.util.List;

public class Partition {
    public static List<Integer> quickSort(List<Integer> arr) {
        int low = 0;
        int high = arr.size() - 1;
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

        return new ArrayList<>(arr);
    }
}
