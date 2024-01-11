import java.util.*;

public class Main {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int v1 = scanner.nextInt();
        scanner.nextLine();

        int[] list = new int[v1];
        for (int i = 0; i < v1; i++) {
            list[i] = scanner.nextInt();
        }

        scanner.close();

        Arrays.sort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
}