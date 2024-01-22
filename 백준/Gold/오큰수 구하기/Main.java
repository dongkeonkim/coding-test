import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    int N;
    int[] req = new int[1000001];
    int[] res = new int[1000001];

    Stack<Integer> stack = new Stack<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      req[i] = Integer.parseInt(st.nextToken());
      res[i] = -1;
    }

    for (int i = 0; i < N; i++) {
      while (!stack.isEmpty() && req[stack.peek()] < req[i]) {
        int idx = stack.pop();
        res[idx] = req[i];
      }
      stack.push(i);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(res[i]);
      sb.append(" ");
    }
    System.out.println(sb);
  }
}
