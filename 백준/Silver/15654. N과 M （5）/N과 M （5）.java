import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int M;
  static StringBuilder sb;

  static int[] arr;
  static int[] inputArr;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    inputArr = new int[N];
    arr = new int[M];
    visited = new boolean[N];

    sb = new StringBuilder();
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      inputArr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(inputArr);

    dfs(0, 0);

    System.out.println(sb);
  }

  public static void dfs(int depth, int idx) {
    if (depth == M) {
      for (int t : arr) {
        sb.append(t + " ");
      }

      sb.append("\n");
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        arr[idx] = inputArr[i];
        dfs(depth + 1, idx + 1);
        visited[i] = false;
      }
    }
  }
}
