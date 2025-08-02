import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = st.countTokens();
            for (int j = 0; j < cnt; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int dp[][] = new int[n][n];
        dp[0][0] = arr[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                } else if ( j == i ) {
                    dp[i][j] = dp[i - 1][j-1] + arr[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + arr[i][j];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int l : dp[n-1]) {
            max =  Math.max(max, l);
        }
        System.out.println(max);
    }
}