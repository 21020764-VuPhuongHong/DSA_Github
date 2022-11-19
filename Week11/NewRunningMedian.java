import java.util.*;

public class NewRunningMedian {
    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> median = new ArrayList<>();
        List<Pair> medianPairList = new ArrayList<>();
        TreeSet<Pair> treeSet = new TreeSet<>();

        Pair element0 = new Pair(a.get(0), 0);

        treeSet.add(element0);
        medianPairList.add(element0);
        median.add(element0.key);
        for (int i = 1; i < a.size(); i++) {
            Pair lastMedian = medianPairList.get(medianPairList.size() - 1);
            Pair element = new Pair(a.get(i), i);
            treeSet.add(element);
            if ((i + 1) % 2 != 0) {
                if (element.compareTo(lastMedian) > 0) {
                    medianPairList.add(treeSet.higher(lastMedian));
                } else {
                    medianPairList.add(treeSet.lower(lastMedian));
                }
            } else {
                if (element.compareTo(lastMedian) > 0) {
                    medianPairList.add(new Pair((treeSet.higher(lastMedian).key + lastMedian.key) / 2,
                            (treeSet.higher(lastMedian).value + lastMedian.value) / 2));
                } else {
                    medianPairList.add(new Pair((treeSet.lower(lastMedian).key + lastMedian.key) / 2,
                            (treeSet.lower(lastMedian).value + lastMedian.value) / 2));
                }
            }
            median.add(medianPairList.get(medianPairList.size() - 1).key);
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
