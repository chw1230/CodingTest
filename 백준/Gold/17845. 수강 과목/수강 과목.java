import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] I = new int[K + 1];
        int[] T = new int[K + 1];

        for (int j = 1; j <= K; j++) {
            st = new StringTokenizer(br.readLine());
            I[j] = Integer.parseInt(st.nextToken());
            T[j] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[N + 1];

        long max = 0;
        for (int i = 1; i <= K; i++) {
            for (int j = N; j >= T[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - T[i]] + I[i]);
                max = Math.max(max, dp[j]);
            }
        }
        System.out.println(max);
    }
}