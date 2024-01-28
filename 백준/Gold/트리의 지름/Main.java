import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static ArrayList<Node>[] array;
  static boolean[] visited;
  static int[] lengths;
  static int max;
  static int idx;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int V = Integer.parseInt(br.readLine());
    array = new ArrayList[V + 1];
    visited = new boolean[V + 1];
    lengths = new int[V + 1];
    max = 0;
    idx = 0;

    for (int i = 1; i <= V; i++) {
      array[i] = new ArrayList<Node>();
    }

    for (int i = 1; i <= V; i++) {
      String[] temp = br.readLine().split(" ");
      int node = Integer.parseInt(temp[0]);
      int j = 1;

      while (true) {
        int v = Integer.parseInt(temp[j]);
        if (v == -1) {
          break;
        }
        int l = Integer.parseInt(temp[j + 1]);

        array[node].add(new Node(v, l));
        j += 2;
      }
    }

    visited[2] = true;
    dfs(2, 0);

    visited = new boolean[V + 1];
    lengths = new int[V + 1];

    max = 0;
    visited[idx] = true;
    dfs(idx, 0);

    System.out.println(max);
  }

  static void dfs(int index, int length) {
    for (Node node : array[index]) {
      if (!visited[node.e]) {
        if (max < lengths[index] + node.v) {
          max = lengths[index] + node.v;
          idx = node.e;
        }

        lengths[node.e] = lengths[index] + node.v;
        visited[node.e] = true;
        dfs(node.e, node.v);
      }
    }
  }

  static class Node {

    int e;
    int v;

    Node(int e, int v) {
      this.e = e;
      this.v = v;
    }
  }
}
