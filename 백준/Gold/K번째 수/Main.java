import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int k = sc.nextInt();

    sc.close();

    int left = 1;
    int right = k;

    while (left <= right) {
      int mid = (left + right) / 2;
      int cnt = 0;
      for (int i = 1; i <= N; i++) {
        cnt += Math.min(mid / i, N);
      }
      if (cnt < k) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    System.out.println(left);
  }
}
