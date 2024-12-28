import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int X = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
        }
        sc.close();

        ArrayList<Integer> result = bfs(graph, N, K, X);
        Collections.sort(result);
        
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int city : result) {
                System.out.println(city);
            }
        }
    }

    private static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> graph, int N, int K, int X) {
        boolean[] visited = new boolean[N + 1];
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        visited[X] = true;
        queue.add(new int[] { X, 0 });

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int distance = current[1];

            if (distance == K) {
                result.add(node);
            }

            if (distance < K) {
                for (int neighbor : graph.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(new int[] { neighbor, distance + 1 });
                    }
                }
            }
        }
        return result;
    }

}