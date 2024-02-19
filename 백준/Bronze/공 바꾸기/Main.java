import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    int[] ns = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      ns[i] = i;
    }

    int tempA = 0;
    int tempB = 0;
    int temp = 0;
    for (int i = 0; i < M; i++) {
      tempA = sc.nextInt();
      tempB = sc.nextInt();

      temp = ns[tempA];
      ns[tempA] = ns[tempB];
      ns[tempB] = temp;
    }

    sc.close();

    for (int i = 1; i <= N; i++) {
      System.out.print(ns[i] + " ");
    }
  }
}