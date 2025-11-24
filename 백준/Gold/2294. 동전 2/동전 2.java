import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int INF = 10001;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            dp[i] = INF;
        }
        dp[0] = 0;

        for (int i : arr) {
            for (int j = i; j <= k; j++) {
                if (dp[j - i] != INF) {
                    dp[j] = Math.min(dp[j], dp[j - i] + 1);
                }
            }
        }

        if (dp[k] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}