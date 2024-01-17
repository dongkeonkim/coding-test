import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    dfs(2, 1); // 2, 1을 dfs에 적용.
    dfs(3, 1);
    dfs(5, 1);
    dfs(7, 1);
  }

  public static void dfs(int num, int digit) {
    // 1. digit == 4가 아니기 때문에 실행
    if (digit == N) {
      // 숫자가 소수라면 출력
      if (isPrime(num)) {
        System.out.println(num);
      }
      // 아니라면 리턴
      return;
    }

    // 1. 1부터 9까지 ++
    for (int i = 1; i < 10; i++) {
      // 1. num에 * 10을 한 값 + i를 한 값이 소수라면
      if (isPrime(num * 10 + i)) {
        // 1. 해당 값과 2번째 자리 수를 확인.
        dfs(num * 10 + i, digit + 1);
      }
    }
  }

  static boolean isPrime(int num) {
    for (int i = 2; i <= num / 2; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}
