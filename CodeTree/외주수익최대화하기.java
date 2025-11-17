package 삼성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외주수익최대화하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] T  = new int[n+2];
        int[] P = new int[n+2];
        int[] dp = new int[n+2];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n; i > 0; i--) {
            int nxt = i + T[i];

            /*
            if (nxt >= n + 1) { dp[i] = dp[i + 1]; } 가 아닌 이유
            -> n일날 하루 일이 가능하면 dp[n] 수익이 들어갈 수 있는 것인데,
            >= 라고 해버리면 자동으로 dp[n+1] (값이 0)이 들어와 버림
             */
            if (nxt > n + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(P[i] + dp[nxt], dp[i + 1]);
            }
        }
        System.out.println(dp[1]);
    }
}
