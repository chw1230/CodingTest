import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] l = new int[n + 1];
        int[] j = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int k = 1; k <= n; k++) {
            l[k] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int k = 1; k <= n; k++) {
            j[k] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[101];

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int k = 100; k > l[i]; k--) {
                dp[k] = Math.max(dp[k], dp[k - l[i]] + j[i]);
                max = Math.max(max, dp[k]);
            }
        }
        if (max == Integer.MIN_VALUE) {
            System.out.println(0);
            return;
        }
        System.out.println(max);
    }
}