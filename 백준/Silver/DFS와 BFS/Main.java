import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static ArrayList<ArrayList<Integer>> arr;
  static boolean[] visited;
  static ArrayList<Integer> visitedNode;

  static int N;
  static int M;
  static int V;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());

    arr = new ArrayList<ArrayList<Integer>>();
    visited = new boolean[N + 1];
    visitedNode = new ArrayList<>();

    for (int i = 0; i <= N; i++) {
      arr.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      arr.get(a).add(b);
      arr.get(b).add(a);
    }

    for (int i = 0; i <= N; i++) {
      Collections.sort(arr.get(i));
    }

    dfs(V);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < visitedNode.size(); i++) {
      sb.append(visitedNode.get(i) + " ");
    }

    System.out.println(sb);

    visited = new boolean[N + 1];
    visitedNode = new ArrayList<>();

    bfs(V);

    sb = new StringBuilder();
    for (int i = 0; i < visitedNode.size(); i++) {
      sb.append(visitedNode.get(i) + " ");
    }

    System.out.println(sb);
  }

  public static void dfs(int idx) {
    visited[idx] = true;
    visitedNode.add(idx);

    for (int i : arr.get(idx)) {
      if (!visited[i]) {
        dfs(i);
      }
    }
  }

  public static void bfs(int idx) {
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.offer(idx);
    visited[idx] = true;

    while (!queue.isEmpty()) {
      int item = queue.poll();
      visitedNode.add(item);

      for (int i : arr.get(item)) {
        if (!visited[i]) {
          visited[i] = true;
          queue.offer(i);
        }
      }
    }
  }
}