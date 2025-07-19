import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 운동 기구의 개수

        long arr[] = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong((st.nextToken()));
        }
        Arrays.sort(arr);

        long M = Long.MIN_VALUE; // 근손실 정도
        if ( N % 2 == 0 ) { // 짝수인 경우
            for (int i = 0; i < N; i++) {
                M = Math.max(M, arr[i]+arr[N-1-i]);
            }
        } else {
            for (int i = 0; i < N-1; i++) {
                M = Math.max(M, arr[i]+arr[N-2-i]);
            }
            M = Math.max(M, arr[N-1]);
        }
        System.out.println(M);
    }
}