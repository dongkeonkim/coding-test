import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    for (int i = 1; i <= N; i++) {
      for (int a = 1; a <= N - i; a++) {
        System.out.print(" ");
      }

      for (int b = 1; b <= i; b++) {
        System.out.print("*");
      }
      System.out.println("");
    }

    sc.close();
  }
}
