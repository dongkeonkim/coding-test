import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean[] students = new boolean[31];

    for (int i = 1; i <= 28; i++) {
      students[sc.nextInt()] = true;
    }

    sc.close();

    for (int i = 1; i <= 30; i++) {
      if (!students[i]) {
        System.out.println(i);
      }
    }
  }
}
