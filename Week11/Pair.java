public class Pair implements Comparable<Pair> {
    public Double key;
    public Double value;
    public Pair(double k, double v) {
        key = k;
        value = v;
    }
    public int compareTo(Pair other) {
        if (key.compareTo(other.key) > 0) {
            return 1;
        } else if (key.compareTo(other.key) < 0) {
            return -1;
        } else {
            if (value.compareTo(other.value) > 0) {
                return 1;
            } else if (value.compareTo(other.value) < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
