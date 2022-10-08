import java.util.List;

public class BinarySearch {
    public static int introTutorial(int V, List<Integer> arr) {
        int low = 0;
        int high = arr.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = arr.get(mid);

            if (midValue < V)
                low = mid + 1;
            else if (midValue > V)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
