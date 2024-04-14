import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int M;
  static int[] arr;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[M];
    sb = new StringBuilder();

    dfs(0, 0);

    System.out.println(sb);
  }

  public static void dfs(int depth, int test) {
    if (depth == M) {
      for (int i : arr) {
        sb.append(i + " ");
      }
      sb.append("\n");
      return;
    }

    for (int i = test; i < N; i++) {
      arr[depth] = i + 1;
      dfs(depth + 1, arr[depth] - 1);
    }
  }
}
