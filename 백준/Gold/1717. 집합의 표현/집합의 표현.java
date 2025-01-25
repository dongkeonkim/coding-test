import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException {

        // 같은 집합에 있는지 확인하는 로직
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        rank = new int[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (type == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.println(sb);
    }

    private static void union(int a, int b) {
        int aVal = find(a);
        int bVal = find(b);

        if (rank[aVal] > rank[bVal]) {
            parent[bVal] = aVal;
        } else if (rank[aVal] < rank[bVal]) {
            parent[aVal] = bVal;
        } else {
            parent[bVal] = aVal;
            rank[aVal]++;
        }
    }

    private static int find(int val) {
        if (parent[val] == val) {
            return val;
        }
        parent[val] = find(parent[val]);
        return parent[val];
    }
}