import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i] = Integer.parseInt(st.nextToken());
    }

    mergeSort(arr);

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < N; i++) {
      bw.write(arr[i] + " ");
    }

    bw.flush();
    bw.close();
  }

  public static void mergeSort(int[] arr) {
    if (arr.length <= 1) return;

    int size = arr.length / 2;
    int j = 0;

    int[] lArr = new int[size];
    int[] rArr = new int[arr.length - size];

    for (int i = 0; i < arr.length; i++) {
      if (i < size) {
        lArr[i] = arr[i];
      } else {
        rArr[j] = arr[i];
        j++;
      }
    }

    mergeSort(lArr);
    mergeSort(rArr);
    merge(arr, lArr, rArr);
  }

  public static void merge(int[] arr, int[] lArr, int[] rArr) {
    int i = 0, l = 0, r = 0;

    while (l < lArr.length && r < rArr.length) {
      if (lArr[l] < rArr[r]) {
        arr[i] = lArr[l];
        l++;
      } else {
        arr[i] = rArr[r];
        r++;
      }
      i++;
    }

    while (l < lArr.length) {
      arr[i] = lArr[l];
      l++;
      i++;
    }

    while (r < rArr.length) {
      arr[i] = rArr[r];
      r++;
      i++;
    }
  }
}