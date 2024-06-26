import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] arr;
  static int n, m;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[m];

    dfs(1, 0);
    System.out.println(sb);
  }

  public static void dfs(int idx, int depth) {
    if (depth == m) {
      for (int temp : arr) {
        sb.append(temp).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = idx; i <= n; i++) {
      arr[depth] = i;
      dfs(i + 1, depth + 1);
    }
  }
}