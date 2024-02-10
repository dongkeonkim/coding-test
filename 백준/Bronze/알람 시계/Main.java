import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();

    sc.close();

    int t = b - 45;

    if (t < 0) {
      if (a - 1 < 0) {
        a = 23;
      } else {
        a -= 1;
      }

      b = 60 + t;
    } else {
      b = t;
    }
    System.out.println(a + " " + b);
  }
}
