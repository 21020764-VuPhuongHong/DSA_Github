public class Vertice implements Comparable<Vertice> {
    private int vertice;
    private int cost;

    public Vertice(int v, int cost) {
        this.vertice = v;
        this.cost = cost;
    }

    public int getVertice() {
        return vertice;
    }

    @Override
    public int compareTo(Vertice o) {
        if (this.cost > o.cost) {
            return 1;
        } else if (this.cost < o.cost) {
            return -1;
        } else {
            return 0;
        }
    }
}
