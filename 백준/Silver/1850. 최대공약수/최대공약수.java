import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = new BigInteger(sc.next());
        BigInteger b = new BigInteger(sc.next());
        sc.close();

        int result = gcd(a, b);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result; i++) {
            sb.append("1");
        }

        System.out.println(sb.toString());
    }

    private static int gcd(BigInteger a, BigInteger b) {
        while (b.compareTo(BigInteger.ZERO) != 0) {
            BigInteger temp = b;
            b = a.mod(b);
            a = temp;
        }

        return a.intValue();
    }

}