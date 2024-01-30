import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int start = 0;
    int end = 0;

    int[] Ns = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int temp = Integer.parseInt(st.nextToken());
      Ns[i] = temp;
      end += temp;
      if (temp > start) {
        start = temp;
      }
    }

    while (start <= end) {
      int mid = (start + end) / 2;
      int sum = 0;
      int cnt = 0;
      for (int i = 0; i < N; i++) {
        if (sum + Ns[i] > mid) {
          cnt++;
          sum = 0;
        }
        sum = sum + Ns[i];
      }
      if (sum != 0) {
        cnt++;
      }
      if (cnt > M) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    System.out.println(start);
  }
}
