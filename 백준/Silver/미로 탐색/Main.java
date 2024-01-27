import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[][] array;
  static boolean[][] visited;
  static int N;
  static int M;

  static int[] xr = { 0, 1, 0, -1 };
  static int[] yr = { 1, 0, -1, 0 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    array = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String temp = br.readLine();
      for (int j = 0; j < M; j++) {
        array[i][j] = Integer.parseInt(temp.substring(j, j + 1));
      }
    }

    bfs(0, 0);
    System.out.println(array[N - 1][M - 1]);
  }

  public static void bfs(int i, int j) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] { i, j });
    visited[i][j] = true;

    while (!queue.isEmpty()) {
      int[] t = queue.poll();
      if (array[t[0]][t[1]] != 0) {
        for (int k = 0; k < 4; k++) {
          int x = t[0] + xr[k];
          int y = t[1] + yr[k];
          if (x >= 0 && y >= 0 && x < N && y < M) {
            if (array[x][y] >= 1 && !visited[x][y]) {
              visited[x][y] = true;
              array[x][y] += array[t[0]][t[1]];
              queue.offer(new int[] { x, y });
            }
          }
        }
      }
    }
  }
}