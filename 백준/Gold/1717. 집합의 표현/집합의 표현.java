import java.util.*;

public class Main {

  static int[] parent;
  static int[] rank;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    parent = new int[n + 1];
    rank = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      parent[i] = i;
      rank[i] = 0;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      int type = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();

      if (type == 0) {
        union(a, b);
      } else {
        if (find(a) == find(b)) {
          sb.append("YES\n");
        } else {
          sb.append("NO\n");
        }
      }
    }

    sc.close();

    System.out.println(sb);
  }

  private static int find(int x) {
    if (parent[x] == x) {
      return x;
    } else {
      return parent[x] = find(parent[x]);
    }
  }

  private static void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);

    if (rootX != rootY) {
      if (rank[rootX] > rank[rootY]) {
        parent[rootY] = rootX;
      } else if (rank[rootY] < rank[rootX]) {
        parent[rootX] = rootY;
      } else {
        parent[rootX] = rootY;
        rank[rootY]++;
      }
    }
  }
}
