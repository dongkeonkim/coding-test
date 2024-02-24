import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int len = Integer.parseInt(br.readLine());
    String[] inputs = new String[len];
    int cnt = 0;

    for (int i = 0; i < len; i++) {
      inputs[i] = br.readLine();
    }

    for (int i = 0; i < len; i++) {
      String[] temp_inputs = inputs[i].split("");
      boolean[] visited = new boolean[26];
      boolean result = true;
      int val = 0;

      for (int j = 0; j < temp_inputs.length; j++) {
        int temp = temp_inputs[j].charAt(0) - 97;

        if (!visited[temp] || val == temp) {
          visited[temp] = true;
          val = temp;
        } else {
          result = false;
          break;
        }
      }

      if (result) {
        cnt++;
      }
    }

    System.out.println(cnt);
  }
}
