import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int max;

  static int n;
  static int[] arr;
  static int[] vals;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    arr = new int[n];
    vals = new int[n];
    visited = new boolean[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    dfs(0);

    System.out.println(max);
  }

  public static void dfs(int depth) {
    if (depth == n) {
      int total = 0;
      for (int i = 0; i < n - 1; i++) {
        total += Math.abs(vals[i] - vals[i + 1]);
      }

      if (total > max) {
        max = total;
      }

      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        vals[depth] = arr[i];
        dfs(depth + 1);
        visited[i] = false;
      }
    }
  }
}
