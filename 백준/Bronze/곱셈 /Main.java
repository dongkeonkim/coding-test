import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int A = Integer.parseInt(sc.nextLine());
    int B = sc.nextInt();
    sc.close();

    String[] splitB = String.valueOf(B).split("");

    for (int i = splitB.length - 1; i >= 0; i--) {
      System.out.println(A * Integer.parseInt(splitB[i]));
    }

    System.out.println(A * B);
  }
}
