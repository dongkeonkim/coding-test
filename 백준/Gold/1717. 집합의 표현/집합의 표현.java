import java.util.Scanner;

public class Main {

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int type = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

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

        sc.close();
        System.out.println(sb);
    }

    private static int find(int x) {
        if (parent[x] != x) {
            return find(parent[x]);
        } else {
            return parent[x];
        }
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }

}