import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class JesseCookies {
    public static int cookies(int k, List<Integer> A) {
        Queue<Integer> pQueue = new PriorityQueue<>();
        for (int i = 0; i < A.size(); i++) {
            pQueue.add(A.get(i));
        }
        int count = 0;
        while (pQueue.size() > 0) {
            if (pQueue.peek() < k) {
                int min = pQueue.poll();
                if (pQueue.isEmpty()){
                    count = -1;
                    break;
                }
                int secondMin = pQueue.poll();
                pQueue.add(min + 2 * secondMin);
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
