import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] ns = new int[N];

    for (int i = 0; i < N; i++) {
      ns[i] = sc.nextInt();
    }

    int v = sc.nextInt();
    int cnt = 0;

    for (int i = 0; i < N; i++) {
      if (ns[i] == v) {
        cnt++;
      }
    }

    System.out.println(cnt);
  }
}
