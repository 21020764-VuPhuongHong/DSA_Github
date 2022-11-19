public class Edge implements Comparable<Edge> {
    private int u;
    private int v;
    private int weight;

    public Edge(int u, int v, int value) {
        this.u = u;
        this.v = v;
        this.weight = value;
    }

    public int eitherVertice() {
        return u;
    }

    public int otherVertice(int vertice) {
        if (vertice == v) {
            return u;
        }
        return v;
    }

    public int getWeight() {
        return weight;
    }

    public int compareTo(Edge other) {
        if (this.weight > other.weight) {
            return 1;
        } else if (this.weight < other.weight) {
            return -1;
        } else {
            return 0;
        }
    }
}
