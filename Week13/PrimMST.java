import java.util.*;

public class PrimMST {
    public static int prims(int n, List<List<Edge>> edges, int start) {
        // Write your code here
        Queue<Edge> pq = new PriorityQueue<>();
        List<Edge> mst = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        int minTotalWeight = 0;
        visit(edges, pq, visited, start);
        while (!pq.isEmpty() && mst.size() < n - 1) {
            Edge e = pq.poll();
            int u = e.eitherVertice();
            int v = e.otherVertice(u);
            if (!(visited[u] && visited[v])) {
                mst.add(e);
                minTotalWeight += e.getWeight();
                if (!visited[u]) {
                    visit(edges, pq, visited, u);
                }
                if (!visited[v]) {
                    visit(edges, pq, visited, v);
                }
            }
        }
        return minTotalWeight;
    }

    public static  void visit(List<List<Edge>> edges, Queue<Edge> pq, boolean[] visited, int v) {
        visited[v] = true;
        for (int i = 0; i < edges.get(v).size(); i++) {
            Edge e = edges.get(v).get(i);
            if (!visited[e.otherVertice(v)]) {
                pq.add(e);
            }
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N, M, start;
        N = scanner.nextInt();
        M = scanner.nextInt();
        List<List<Edge>> edges = new ArrayList<>();
        for (int i = 0; i <= N; ++i) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < M; ++i) {
            int u, v, value;
            u = scanner.nextInt();
            v = scanner.nextInt();
            value = scanner.nextInt();
            Edge e = new Edge(u, v, value);
            edges.get(u).add(e);
            edges.get(v).add(e);
        }
        start = scanner.nextInt();
        System.out.println(prims(N, edges, start));
    }
}
