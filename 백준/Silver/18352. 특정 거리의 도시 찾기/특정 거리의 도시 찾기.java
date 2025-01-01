import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int K = sc.nextInt();
    int X = sc.nextInt();

    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      list.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < M; i++) {
      int from = sc.nextInt();
      int to = sc.nextInt();
      list.get(from).add(to);
    }

    sc.close();

    ArrayList<Integer> result = bfs(list, N, K, X);

    Collections.sort(result);
    if (result.isEmpty()) {
      System.out.println(-1);
    } else {
      for (int i : result) {
        System.out.println(i);
      }
    }
  }

  private static ArrayList<Integer> bfs(
    ArrayList<ArrayList<Integer>> graph,
    int N,
    int K,
    int X
  ) {
    ArrayList<Integer> result = new ArrayList<>();
    boolean[] visited = new boolean[N + 1];
    Queue<Integer[]> queue = new LinkedList<>();
    visited[X] = true;
    queue.add(new Integer[] { X, 0 });

    while (!queue.isEmpty()) {
      Integer[] current = queue.poll();
      int city = current[0];
      int cnt = current[1];

      if (cnt == K) {
        result.add(city);
        continue;
      }

      for (int nextCity : graph.get(city)) {
        if (!visited[nextCity]) {
          visited[nextCity] = true;
          queue.add(new Integer[] { nextCity, cnt + 1 });
        }
      }
    }

    return result;
  }
}
