import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int[] list = new int[N];

    for (int i = 0; i < N; i++) {
      list[i] = sc.nextInt();
    }

    sc.close();

    int min = list[0];
    int max = list[0];

    for (int val : list) {
      if (val < min) {
        min = val;
      }
      if (val > max) {
        max = val;
      }
    }

    System.out.println(min + " " + max);
  }
}
