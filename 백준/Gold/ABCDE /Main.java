import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static ArrayList<ArrayList<Integer>> people;
  static int N;
  static boolean status;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    people = new ArrayList<ArrayList<Integer>>();
    status = false;

    for (int i = 0; i < N; i++) {
      people.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      people.get(a).add(b);
      people.get(b).add(a);
    }

    for (int i = 0; i < N; i++) {
      if (status) {
        System.out.println(1);
        return;
      }
      visited = new boolean[N];
      dfs(i, 1);
    }

    System.out.println(0);
  }

  public static void dfs(int index, int depts) {
    if (depts == 5) {
      status = true;
      return;
    }

    visited[index] = true;

    for (int i : people.get(index)) {
      if (!visited[i]) {
        dfs(i, depts + 1);
      }
    }
    visited[index] = false;
  }
}
