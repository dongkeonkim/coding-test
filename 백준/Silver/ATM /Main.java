import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());

    int[] arr = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    for (int i = 1; i < arr.length; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && key < arr[j]) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }

    int[] sum = new int[n];

    sum[0] = arr[0];
    for (int i = 1; i < n; i++) {
      sum[i] = sum[i - 1] + arr[i];
    }

    int s = 0;
    for (int i = 0; i < n; i++) {
      s = s + sum[i];
    }
    System.out.print(s);
  }
}
