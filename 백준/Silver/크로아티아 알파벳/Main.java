import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    String[] list = new String[] {
      "c=",
      "c-",
      "dz=",
      "d-",
      "lj",
      "nj",
      "s=",
      "z=",
    };

    for (int i = 0; i < list.length; i++) {
      if (input.contains(list[i])) {
        input = input.replace(list[i], "#");
      }
    }

    System.out.println(input.length());
  }
}
