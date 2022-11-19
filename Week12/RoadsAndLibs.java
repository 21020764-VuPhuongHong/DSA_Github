import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoadsAndLibs {
    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        if (c_lib <= c_road) {
            return (long) c_lib * n;
        }

        long cost = 0;
        boolean[] visited = new boolean[n + 1];
        UnionFind uf = new UnionFind(n + 1);
        for (int i = 0; i < cities.size(); i++) {
            uf.union(cities.get(i).get(0), cities.get(i).get(1));
        }
        for (int i = 1; i < n + 1; i++) {
            int root = uf.find(i);
            if (!visited[root]) {
                cost += c_lib;
                cost += (long) (uf.sizeComponent(root) - 1) * c_road;
                visited[root] = true;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        for (int q = 0; q < Q; ++q) {
            int N, M, c_lib, c_road;
            N = scanner.nextInt();
            M = scanner.nextInt();
            c_lib = scanner.nextInt();
            c_road = scanner.nextInt();
            List<List<Integer>> cities = new ArrayList<>();
            for (int i = 0; i < M; ++i) {
                cities.add(new ArrayList<Integer>());
                cities.get(i).add(scanner.nextInt());
                cities.get(i).add(scanner.nextInt());
            }

            System.out.println(roadsAndLibraries(N, c_lib, c_road, cities));
        }
    }
}
