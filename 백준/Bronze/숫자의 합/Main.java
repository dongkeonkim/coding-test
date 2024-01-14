import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int integerCnt = scanner.nextInt();
        scanner.nextLine();
        String integerString = scanner.nextLine();

        scanner.close();

        char[] charArray = integerString.toCharArray();
        int result = 0;

        for (int i = 0; i < charArray.length; i++) {
            result += charArray[i] - '0';
        }

        System.out.println(result);
    }
}