import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static ArrayList<ArrayList<Integer>> adjList;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    adjList = new ArrayList<>();
    visited = new boolean[N + 1];

    for (int i = 0; i <= N; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      adjList.get(u).add(v);
      adjList.get(v).add(u);
    }

    int connectedComponents = 0;
    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        connectedComponents++;
        dfs(i);
      }
    }

    System.out.println(connectedComponents);

    br.close();
  }

  static void dfs(int u) {
    visited[u] = true;

    for (int v : adjList.get(u)) {
      if (!visited[v]) {
        dfs(v);
      }
    }
  }
}
