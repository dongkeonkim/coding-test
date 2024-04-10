import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (hasNextElements()){
            StringBuilder sb = new StringBuilder();
            for (int v : arr) {
                sb.append(v + " ");
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
        
    }

    public static boolean hasNextElements() {
        int i = arr.length - 1;

        while (i > 0 &&  arr[i - 1] < arr[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = arr.length - 1;
        
        while (arr[j] > arr[i - 1]) {
            j--;
        }

        swap(i - 1, j);

        j = arr.length - 1;

        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }

        return true;
    }

    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}