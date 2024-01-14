import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int dataCnt = Integer.parseInt(st.nextToken()); // 데이터의 개수
    int questionCnt = Integer.parseInt(st.nextToken()); // 질의 개수
    Integer[] values = new Integer[dataCnt]; // 데이터 받을 곳

    StringTokenizer valuesToken = new StringTokenizer(br.readLine());
    for (int i = 0; i < dataCnt; i++) {
      values[i] = Integer.parseInt(valuesToken.nextToken());
    }

    Integer[] plusValues = new Integer[values.length + 1];
    plusValues[0] = 0;

    // 구간 합 배열 작업
    for (int i = 1; i <= values.length; i++) {
      plusValues[i] = plusValues[i - 1] + values[i - 1];
    }

    for (int i = 0; i < questionCnt; i++) {
      StringTokenizer test = new StringTokenizer(br.readLine());
      int I = Integer.parseInt(test.nextToken());
      int J = Integer.parseInt(test.nextToken());
      System.out.println(plusValues[J] - plusValues[I - 1]);
    }
  }
}
