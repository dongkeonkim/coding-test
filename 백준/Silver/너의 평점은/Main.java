import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    double total = 0;
    double point = 0;

    for (int i = 0; i < 20; i++) {
      String gbg = sc.next();
      double a = sc.nextDouble();
      String b = sc.next();

      if (b.equals("A+")) {
        total += a * 4.5;
        point += a;
      } else if (b.equals("A0")) {
        total += a * 4.0;
        point += a;
      } else if (b.equals("B+")) {
        total += a * 3.5;
        point += a;
      } else if (b.equals("B0")) {
        total += a * 3.0;
        point += a;
      } else if (b.equals("C+")) {
        total += a * 2.5;
        point += a;
      } else if (b.equals("C0")) {
        total += a * 2.0;
        point += a;
      } else if (b.equals("D+")) {
        total += a * 1.5;
        point += a;
      } else if (b.equals("D0")) {
        total += a * 1.0;
        point += a;
      } else if (b.equals("F")) {
        total += a * 0.0;
        point += a;
      }
    }

    sc.close();

    System.out.printf("%.6f", total / point);
  }
}
