import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int X = sc.nextInt();
    ArrayList<Integer> arr = new ArrayList<Integer>();

    int temp = 0;
    for (int i = 0; i < N; i++) {
      temp = sc.nextInt();
      if (temp < X) {
        arr.add(temp);
      }
    }

    sc.close();

    for (int i = 0; i < arr.size(); i++) {
      if (i != arr.size() - 1) {
        System.out.print(arr.get(i) + " ");
      } else {
        System.out.print(arr.get(i));
      }
    }
  }
}
