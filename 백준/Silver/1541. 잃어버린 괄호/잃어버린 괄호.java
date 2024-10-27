import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String math = br.readLine();

        String[] arr = math.split("-");
        int total = 0;
        int value = 0;
        for (int i = 0; i < arr.length; i++) {
            value = sum(arr[i]);
            if (i == 0) {
                total += value;
            } else {
                total -= value;
            }
        }
        System.out.println(total);
    }

    private static int sum(String arr) {
        int sum = 0;
        for (String s : arr.split("[+]")) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}