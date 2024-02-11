import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int max = 0;

    if (a == b && b == c) {
      System.out.println(10000 + (a * 1000));
    } else if ((a == b && a != c) || (a == c && a != b) || (b == c && b != a)) {
      if (a == b && a != c) {
        System.out.println(1000 + (a * 100));
      } else {
        System.out.println(1000 + (c * 100));
      }
    } else {
      max = a > b ? a : b;
      System.out.println(c > max ? c * 100 : max * 100);
    }

    sc.close();
  }
}
