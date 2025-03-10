package thisisCodingTest.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];

        if (N == 1) { // 1인 경우 dp[2]가 생성될 수 없음
            System.out.println(1);
            return;
        }
        dp[1] = 1;
        dp[2] = 2;
        // 직접 해보며 규칙을 찾아내서 점화식을 작성하였음

        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }
        System.out.println(dp[N]);
    }
}
