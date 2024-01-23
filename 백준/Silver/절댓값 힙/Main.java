import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
      int first = Math.abs(a);
      int second = Math.abs(b);
      if (first == second) {
        return a > b ? 1 : -1;
      } else {
        return first - second;
      }
    });

    int N = sc.nextInt();

    int temp;
    for (int i = 0; i < N; i++) {
      temp = sc.nextInt();

      if (temp == 0) {
        if (queue.isEmpty()) {
          System.out.println("0");
        } else {
          System.out.println(queue.poll());
        }
      } else {
        queue.add(temp);
      }
    }

    sc.close();
  }
}