import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int max = 0;
    int idx = 0;
    int temp = 0;
    for (int i = 1; i <= 9; i++) {
      temp = sc.nextInt();
      if (temp > max) {
        max = temp;
        idx = i;
      }
    }
    sc.close();
    System.out.println(max);
    System.out.println(idx);
  }
}
