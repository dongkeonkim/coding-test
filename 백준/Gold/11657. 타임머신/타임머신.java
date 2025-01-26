import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int start, end, time;
        
        Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수
        
        ArrayList<Edge> edges = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            
            edges.add(new Edge(start, end, time));
        }
        
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        
        boolean hasNegativeCycle = false;
        
        for (int i = 1; i <= N; i++) {
            for (Edge edge : edges) {
                if (dist[edge.start] != Long.MAX_VALUE && 
                    dist[edge.end] > dist[edge.start] + edge.time) {
                    dist[edge.end] = dist[edge.start] + edge.time;
                    
                    if (i == N) {
                        hasNegativeCycle = true;
                        break;
                    }
                }
            }
        }
        
        if (hasNegativeCycle) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= N; i++) {
                if (dist[i] == Long.MAX_VALUE) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(dist[i]).append('\n');
                }
            }
            System.out.print(sb);
        }
    }
}