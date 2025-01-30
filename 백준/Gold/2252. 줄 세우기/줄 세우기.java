import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            nodes[A].neighbors.add(B);
            nodes[B].distance++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (nodes[i].distance == 0) {
                queue.offer(nodes[i].id);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int nodeId = queue.poll();
            result.add(nodeId);

            for (int neighbor : nodes[nodeId].neighbors) {
                nodes[neighbor].distance--;
                if (nodes[neighbor].distance == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        for (int n : result) {
            System.out.print(n + " ");
        }

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