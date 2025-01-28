import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int start, end, weight;
        
        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
        
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, weight));
        }
        
        Collections.sort(edges);
        
        long answer = 0;
        
        for (Edge edge : edges) {
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                answer += edge.weight;
            }
        }
        
        System.out.println(answer);
    }
    
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x != y) {
            parent[y] = x;
        }
    }
}