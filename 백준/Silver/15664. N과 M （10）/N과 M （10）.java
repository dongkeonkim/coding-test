import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int M;

  static Set<String> set;

  static int[] arr;
  static int[] inputs;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[M];
    inputs = new int[N];
    visited = new boolean[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      inputs[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(inputs);

    set = new LinkedHashSet<>();

    dfs(0, 0);

    StringBuilder sb = new StringBuilder();

    for (String t : set) {
      sb.append(t);
    }

    System.out.println(sb);
  }

  public static void dfs(int depth, int idx) {
    if (depth == M) {
      String result = "";
      for (int temp : arr) {
        result += temp + " ";
      }
      set.add(result + "\n");
      return;
    }

    for (int i = idx; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        arr[depth] = inputs[i];
        dfs(depth + 1, i);
        visited[i] = false;
      }
    }
  }
}
