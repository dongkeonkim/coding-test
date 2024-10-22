import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> zeroPq = new PriorityQueue<>();
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        List<Integer> results = new ArrayList<>();

        int input = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            input = Integer.parseInt(st.nextToken());
            if (input > 0) {
                plusPq.add(input);
            } else if (input < 0) {
                minusPq.add(input);
            } else {
                zeroPq.add(input);
            }
        }

        int value1 = 0;
        int value2 = 0;

        while (plusPq.size() >= 2) {
            value1 = plusPq.poll();
            value2 = plusPq.poll();

            if (value1 + value2 > value1 * value2) {
                results.add(value1 + value2);
            } else {
                results.add(value1 * value2);
            }
        }

        if (plusPq.size() > 0) {
            results.add(plusPq.poll());
        }

        int zeroSize = zeroPq.size();

        while (minusPq.size() >= 2) {
            value1 = minusPq.poll();
            value2 = minusPq.poll();

            if (value1 + value2 > value1 * value2) {
                results.add(value1 + value2);
            } else {
                results.add(value1 * value2);
            }
        }

        if (!minusPq.isEmpty() && zeroSize == 0) {
            results.add(minusPq.poll());
        }

        int sum = 0;
        for (int val : results) {
            sum += val;
        }

        System.out.println(sum);
    }
}