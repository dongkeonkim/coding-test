import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static boolean[][] board;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    board = new boolean[N][M];
    String temp;
    for (int i = 0; i < N; i++) {
      temp = br.readLine();
      for (int j = 0; j < M; j++) {
        board[i][j] = temp.charAt(j) == 'W' ? true : false;
      }
    }
    int min = 64;
    for (int i = 0; i < N - 7; i++) {
      for (int j = 0; j < M - 7; j++) {
        int result = find(i, j);
        if (min > result) {
          min = result;
        }
      }
    }
    System.out.println(min);
  }

  public static int find(int xStart, int yStart) {
    int count = 0;
    boolean color = board[xStart][yStart];
    for (int i = xStart; i < xStart + 8; i++) {
      for (int j = yStart; j < yStart + 8; j++) {
        if (board[i][j] != color) {
          count++;
        }
        color = !color;
      }
      color = !color;
    }
    return Math.min(count, 64 - count);
  }
}