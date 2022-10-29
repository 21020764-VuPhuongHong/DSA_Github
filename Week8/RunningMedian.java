import java.util.*;

public class RunningMedian {
    public static List<Double> runningMedian(List<Integer> a) {
        Queue<Integer> minPQ = new PriorityQueue<>();
        Queue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        List<Double> median = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (maxPQ.size() > 0 && a.get(i) <= maxPQ.peek()) {
                maxPQ.add(a.get(i));
            } else {
                minPQ.add(a.get(i));
            }

            if (maxPQ.size() > minPQ.size() + 1) {
                minPQ.add(maxPQ.poll());
            } else if (minPQ.size() > maxPQ.size() + 1) {
                maxPQ.add(minPQ.poll());
            }

            if (maxPQ.size() == minPQ.size()) {
                median.add((maxPQ.peek() + minPQ.peek()) / 2.0);
            } else if (maxPQ.size() == minPQ.size() + 1) {
                median.add((double) maxPQ.peek());
            } else if (minPQ.size() == maxPQ.size() + 1) {
                median.add((double) minPQ.peek());
            }
        }
        return median;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        System.out.println(runningMedian(arr));
    }
}
