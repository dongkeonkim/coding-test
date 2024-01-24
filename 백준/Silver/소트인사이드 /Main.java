import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();

    int size = s.length();
    int[] n = new int[size];

    for (int i = 0; i < size; i++) {
      n[i] = Integer.parseInt(s.substring(i, i + 1));
    }

    for (int i = 0; i < size; i++) {
      int temp_idx = i;

      for (int j = i + 1; j < size; j++) {
        if (n[temp_idx] < n[j]) {
          temp_idx = j;
        }
      }

      int temp = n[i];
      n[i] = n[temp_idx];
      n[temp_idx] = temp;
    }

    for (int i = 0; i < size; i++) {
      System.out.print(n[i]);
    }
  }
}
