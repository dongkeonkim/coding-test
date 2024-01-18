import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    String[] values = br.readLine().split(" ");
    int[] vals = new int[N];

    for (int i = 0; i < N; i++) {
      vals[i] = Integer.parseInt(values[i]);
    }

    Arrays.sort(vals);
    int count = 0;

    for (int i = 0; i < N; i++) {
      int test = vals[i];
      int sp = 0;
      int ep = 0;

      // SP(스타트 포인트)가 N(길이)보다 작으면 반복
      while (sp < N) {
        if (ep == N) {
          // EP(엔드 포인트)가 N(길이)와 같으면 SP증가, EP 내리기
          sp++;
          ep = sp + 1;
        } else if (sp == ep) {
          // SP(스타트 포인트)가 EP(엔드 포인트)와 같으면 EP 증가
          ep++;
        } else if (sp == i) {
          sp++;
        } else if (ep == i) {
          ep++;
        } else if (vals[sp] + vals[ep] == test) {
          // SP(스타트 포인트)의 값과 EP(엔드 포인트)를 더한 겂이 찾는 값과 같다면
          count++;
          break;
        } else if (vals[sp] + vals[ep] > test) {
          sp++;
          ep = sp + 1;
        } else {
          ep++;
        }
      }
    }

    System.out.println(count);
  }
}
