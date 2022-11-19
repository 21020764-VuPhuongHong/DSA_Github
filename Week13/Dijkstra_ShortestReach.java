import java.util.*;

public class Dijkstra_ShortestReach {
    public static int[] shortestReach(int n, List<List<Edge>> edges, int start) {
        // Write your code here
        int[] distTo = new int[n + 1];
        Queue<Vertice> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            distTo[i] = Integer.MAX_VALUE;
        }

        distTo[start] = 0;
        Vertice startVertice = new Vertice(start, 0);
        pq.add(startVertice);

        while (!pq.isEmpty()) {
            int v = pq.poll().getVertice();
            for (int i = 0; i < edges.get(v).size(); i++) {
                Edge e = edges.get(v).get(i);
                int w = e.otherVertice(v);
                if (distTo[w] > distTo[v] + e.getWeight()) {
                    Vertice lastW = new Vertice(w, distTo[w]);
                    distTo[w] = distTo[v] + e.getWeight();
                    Vertice newW = new Vertice(w, distTo[w]);
                    if (pq.contains(lastW)) {
                        pq.remove(lastW);
                        pq.add(newW);
                    } else {
                        pq.add(newW);
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (distTo[i] == Integer.MAX_VALUE) {
                distTo[i] = -1;
            }
        }
        return distTo;
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        for (int q = 0; q < Q; q++) {
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
            int[] minCosts = shortestReach(N, edges, start);
            for (int i = 1; i < minCosts.length; i++) {
                if (i != start) {
                    System.out.print(minCosts[i] + " ");
                }
            }
            System.out.print("\n");
        }
    }
}