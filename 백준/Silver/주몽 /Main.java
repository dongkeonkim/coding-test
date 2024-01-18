import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // N개의 재료

    st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken()); // M개의 갑옷을 만드는 데 필요한 수

    String[] vals = br.readLine().split(" "); // N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어짐.

    int[] values = new int[N];
    for (int i = 0; i < N; i++) {
      values[i] = Integer.parseInt(vals[i]);
    }

    int sp = 0;
    int ep = 0;
    int count = 0;

    while (sp < N - 1) {
      if (ep > N - 1) {
        sp++;
        ep = sp + 1;
      } else {
        if (values[sp] + values[ep] == M) {
          count++;
        }

        ep++;
      }
    }

    System.out.println(count);
  }
}
