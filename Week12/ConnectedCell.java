import java.util.Scanner;

public class ConnectedCell {
    private static int[][] grid;
    private static boolean[][] visited;
    private static int N, M;


    static int count_connected(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= M) {
            return 0;
        }
        if (grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }
        visited[row][col] = true;
        return count_connected(row - 1, col - 1) + count_connected(row - 1, col) + count_connected(row - 1, col + 1)
                + count_connected(row, col - 1) + count_connected(row, col + 1)
                + count_connected(row + 1, col - 1) + count_connected(row + 1, col) + count_connected(row + 1, col + 1) + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        grid = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                grid[i][j] = scanner.nextInt();
                visited[i][j] = false;
            }
        }
        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                int cnt = count_connected(i, j);
                if (max < cnt) max = cnt;
            }
        }

        System.out.println(max);

    }
}
