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

    for (int i = 1; i <= M; i++) {
      int left = 0;
      int right = 0;
      int temp = 0;

      left = sc.nextInt();
      right = sc.nextInt();

      while (left < right) {
        temp = ns[right];
        ns[right] = ns[left];
        ns[left] = temp;
        left++;
        right--;
      }
    }

    sc.close();

    for (int i = 1; i <= N; i++) {
      System.out.print(ns[i] + " ");
    }
  }
}
