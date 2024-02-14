import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    BufferedWriter sw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int i = 0; i < N; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      sw.write(a + b + "\n");
    }
    sc.close();

    sw.flush();
  }
}
