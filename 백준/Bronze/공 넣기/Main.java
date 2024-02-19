import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] ns = new int[N + 1];

    int M = sc.nextInt();

    for (int i = 1; i <= M; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      for (int j = a; j <= b; j++) {
        ns[j] = c;
      }
    }

    sc.close();

    for (int i = 1; i <= N; i++) {
      System.out.print(ns[i] + " ");
    }
  }
}
