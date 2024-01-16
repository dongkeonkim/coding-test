import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    int sum = 0;
    int count = 0;
    int start_index = 1;
    int end_index = 1;

    while (start_index < N + 1) {
      if (sum == N) {
        sum = 0;
        count++;
        start_index++;
        end_index = start_index;
      } else if (sum > N) {
        sum = 0;
        start_index++;
        end_index = start_index;
      } else {
        sum += end_index;
        end_index++;
      }
    }

    System.out.println(count);
  }
}
