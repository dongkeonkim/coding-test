import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    sc.close();

    int count = 0;
    int idx = 0;

    while (count != n) {
      idx++;
      if (String.valueOf(idx).contains("666")) {
        count++;
      }
    }

    System.out.println(idx);
  }
}
