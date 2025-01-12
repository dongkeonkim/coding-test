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
      nodes[b].inDegree++;
    }

    sc.close();

    List<Integer> results = customSort(nodes);
    for (int result : results) {
      System.out.print(result + " ");
    }
  }

  private static List<Integer> customSort(Node[] nodes) {
    List<Integer> results = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();

    for (int i = 1; i < nodes.length; i++) {
      if (nodes[i].inDegree == 0) {
        queue.add(nodes[i]);
      }
    }

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      if (node.inDegree == 0) {
        results.add(node.id);
      }

      for (int neighbor : node.neighbors) {
        nodes[neighbor].inDegree--;
        if (nodes[neighbor].inDegree == 0) {
          queue.add(nodes[neighbor]);
        }
      }
    }

    return results;
  }
}

class Node {

  int id;
  int inDegree;
  List<Integer> neighbors;

  public Node(int id) {
    this.id = id;
    this.inDegree = 0;
    this.neighbors = new ArrayList<>();
  }
}
