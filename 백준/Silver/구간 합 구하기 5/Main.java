import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int S = Integer.parseInt(st.nextToken()); // size
    int[][] board = new int[S + 1][S + 1];
    int[][] tBoard = new int[S + 1][S + 1];

    int Q = Integer.parseInt(st.nextToken()); // question

    for (int i = 1; i <= S; i++) {
      StringTokenizer s = new StringTokenizer(br.readLine());
      for (int j = 1; j <= S; j++) {
        board[i][j] = Integer.parseInt(s.nextToken());
      }
    }

    for (int i = 1; i <= S; i++) {
      for (int j = 1; j <= S; j++) {
        tBoard[i][j] =
          tBoard[i - 1][j] +
          tBoard[i][j - 1] -
          tBoard[i - 1][j - 1] +
          board[i][j];
      }
    }

    for (int i = 0; i < Q; i++) {
      StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
      Integer x1 = Integer.parseInt(stringTokenizer.nextToken());
      Integer y1 = Integer.parseInt(stringTokenizer.nextToken());
      Integer x2 = Integer.parseInt(stringTokenizer.nextToken());
      Integer y2 = Integer.parseInt(stringTokenizer.nextToken());

      System.out.println(
        tBoard[x2][y2] -
        tBoard[x1 - 1][y2] -
        tBoard[x2][y1 - 1] +
        tBoard[x1 - 1][y1 - 1]
      );
    }
  }
}
