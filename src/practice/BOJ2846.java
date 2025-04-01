package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2846 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0;
        int high = 0;
        int diff = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if ((arr[i] < arr[i + 1]) && (arr[i] == high) && (arr[i-1] != arr[i])) {
                high = arr[i + 1]; // high 최신화
            } else if (arr[i] < arr[i + 1]) {
                low = arr[i];
                high = arr[i + 1];
            }
            if (diff < (high - low)) {
                diff = high - low;
            }

        }
        System.out.println(diff);
    }
}
