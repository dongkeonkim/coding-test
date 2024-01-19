import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int S = Integer.parseInt(st.nextToken()); // 문자열의 길이
    int P = Integer.parseInt(st.nextToken()); // 슬라이딩 윈도우 범위

    char[] charList = br.readLine().toCharArray(); // 문자 리스트 저장

    int A = 0;
    int C = 0;
    int G = 0;
    int T = 0;

    int[] pass = new int[4]; // 비밀번호는 무조건 4개의 숫자
    int resultCnt = 0;

    st = new StringTokenizer(br.readLine());

    // 비밀번호 저장
    for (int i = 0; i < 4; i++) {
      pass[i] = Integer.parseInt(st.nextToken());
    }

    // 슬라이딩 윈도우 첫 값으로 확인
    for (int i = 0; i < P; i++) {
      switch (charList[i]) {
        case 'A':
          A++;
          break;
        case 'C':
          C++;
          break;
        case 'G':
          G++;
          break;
        case 'T':
          T++;
          break;
      }
    }

    if (A >= pass[0] && C >= pass[1] && G >= pass[2] && T >= pass[3]) {
      resultCnt++;
    }

    int testCount = 0;

    for (int i = 0; i < S; i++) {
      if (testCount + P == S) break;

      switch (charList[testCount]) {
        case 'A':
          A--;
          break;
        case 'C':
          C--;
          break;
        case 'G':
          G--;
          break;
        case 'T':
          T--;
          break;
      }

      switch (charList[P + testCount]) {
        case 'A':
          A++;
          break;
        case 'C':
          C++;
          break;
        case 'G':
          G++;
          break;
        case 'T':
          T++;
          break;
      }
      testCount++;

      if (A >= pass[0] && C >= pass[1] && G >= pass[2] && T >= pass[3]) {
        resultCnt++;
      }
    }

    System.out.println(resultCnt);
  }
}