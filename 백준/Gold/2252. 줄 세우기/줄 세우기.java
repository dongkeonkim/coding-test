import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    Node[] nodes = new Node[N + 1];
    for (int i = 1; i <= N; i++) {
      nodes[i] = new Node(i);
    }

    for (int i = 0; i < M; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      nodes[a].neighbors.add(b);
      nodes[b].distance++;
    }

    sc.close();

    List<Integer> result = customSort(nodes);

    for (int n : result) {
      System.out.print(n + " ");
    }
  }

  private static List<Integer> customSort(Node[] nodes) {
    List<Integer> result = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 1; i < nodes.length; i++) {
      if (nodes[i].distance == 0) {
        queue.add(nodes[i].id);
      }
    }

    while (!queue.isEmpty()) {
      int id = queue.poll();
      result.add(id);

      for (int neighbor : nodes[id].neighbors) {
        nodes[neighbor].distance--;
        if (nodes[neighbor].distance == 0) {
          queue.add(neighbor);
        }
      }
    }

    return result;
  }
}

class Node {

  int id;
  int distance;
  List<Integer> neighbors;

  public Node(int id) {
    this.id = id;
    this.distance = 0;
    this.neighbors = new ArrayList<>();
  }
}
