import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    for (int i = 1; i <= N; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      System.out.println("Case #" + i + ": " + (a + b));
    }

    sc.close();
  }
}
