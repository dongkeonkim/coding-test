import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[N + 1];
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            graph.get(A).add(B);
            inDegree[B]++;
        }
        
        List<Integer> result = topologicalSort(graph, inDegree, N);
        
        for (int student : result) {
            System.out.print(student + " ");
        }
    }

    private static List<Integer> topologicalSort(List<List<Integer>> graph, int[] inDegree, int N) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            
            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        return result;
    }
}