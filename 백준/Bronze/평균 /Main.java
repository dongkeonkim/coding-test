import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int sbjCnt = scanner.nextInt();
        long[] cntArray = new long[sbjCnt];
        for (int i = 0; i < sbjCnt; i++) {
            cntArray[i] = scanner.nextInt();
        }

        scanner.close();
        
        long maxValue = 0;
        for (int i = 0; i < cntArray.length; i++) {
            if (maxValue < cntArray[i]) {
                maxValue = cntArray[i];
            }
        }

        double resultValue = 0L;
        for (int i = 0; i < cntArray.length; i++) {
            resultValue += (double) cntArray[i] / maxValue * 100.0;
        }

        System.out.println(resultValue / sbjCnt);

    }
}