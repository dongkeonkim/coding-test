import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
        }

        List<Integer> result = getShortDistance(graph, visited, X, K);

        Collections.sort(result);

        if (result.isEmpty()) {
            System.out.println("-1");
        } else {
            for (int val : result) {
                System.out.println(val);
            }
        }
    }

    private static List<Integer> getShortDistance(List<List<Integer>> graph, boolean[] visited, int start,
            int goalDistance) {
        List<Integer> result = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { start, 0 });
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int startCity = node[0];
            int distance = node[1];

            for (int neighbor : graph.get(startCity)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;

                    if (goalDistance == distance + 1) {
                        result.add(neighbor);
                        continue;
                    }

                    queue.add(new int[] { neighbor, distance + 1 });
                }
            }
        }

        return result;
    }

}