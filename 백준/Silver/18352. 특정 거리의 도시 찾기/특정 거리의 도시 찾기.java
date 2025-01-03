import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int X = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
        }
        sc.close();

        ArrayList<Integer> result = bfs(graph, X, K);
        Collections.sort(result);

        if (result.isEmpty()) {
            System.out.println("-1");
        } else {
            for (int i : result) {
                System.out.println(i);
            }
        }
    }

    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> graph, int X, int K) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size() + 1];
        ArrayList<Integer> result = new ArrayList<>();

        queue.add(new int[] { X, 0 });
        visited[X] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int city = current[0];
            int distance = current[1];

            if (distance == K) {
                result.add(city);
                continue;
            }

            for (int neighbor : graph.get(city)) {
                if (!visited[neighbor]) {
                    queue.add(new int[] { neighbor, distance + 1 });
                    visited[neighbor] = true;
                }
            }
        }
        return result;
    }
}