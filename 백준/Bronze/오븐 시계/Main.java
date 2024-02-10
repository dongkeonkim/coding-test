import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    if (b + c >= 60) {
      a = a + ((b + c) / 60);
      if (a >= 24) {
        a = a - 24;
      }
      b = (b + c) % 60;
    } else {
      b += c;
    }

    System.out.println(a + " " + b);

    sc.close();
  }
}
