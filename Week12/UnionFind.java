public class UnionFind {
    private int[] parent;
    private int[] size;
    private int count;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        count = n;
    }

    public int countComponents() {
        return count;
    }

    public int sizeComponent(int root) {
        return size[root];
    }

    public int find(int k) {    //logN
        if (k < 0 || k >= parent.length) {
            throw new IllegalArgumentException("index not accepted");
        }
        while (parent[k] != k) {
            parent[k] = parent[parent[k]];
            k = parent[k];
        }
        return k;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }

        if (size[rootP] <= size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }
}

