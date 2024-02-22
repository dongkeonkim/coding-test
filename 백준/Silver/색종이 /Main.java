import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    boolean[][] board = new boolean[101][101];

    int cnt = 0;

    for (int n = 0; n < N; n++) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      for (int i = a; i < a + 10; i++) {
        for (int j = b; j < b + 10; j++) {
          if (!board[i][j]) {
            board[i][j] = true;
            cnt++;
          }
        }
      }
    }

    sc.close();
    System.out.println(cnt);
  }
}
