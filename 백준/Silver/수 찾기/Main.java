import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] ns = new int[n];
    for (int i = 0; i < n; i++) {
      ns[i] = sc.nextInt();
    }
    Arrays.sort(ns);

    int m = sc.nextInt();
    int[] ms = new int[m];
    for (int i = 0; i < m; i++) {
      ms[i] = sc.nextInt();
    }

    sc.close();

    for (int i = 0; i < m; i++) {
      int target = ms[i];
      int start = 0;
      int finish = n - 1;
      int result = 0;

      while (finish >= start) {
        int mid = (finish + start) / 2;
        if (ns[mid] == target) {
          result = 1;
          break;
        } else if (ns[mid] > target) {
          finish = mid - 1;
        } else {
          start = mid + 1;
        }
      }

      System.out.println(result);
    }
  }
}