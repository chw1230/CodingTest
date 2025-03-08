package thisisCodingTest.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 홀짝에 따라서 홀이면 sk이고, 짝이면 cy인 형태임!!
        // sk - true, ys - true 인 형태를 띄게됨!
        boolean[] dp = new boolean[N+1];
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;

        for (int i = 4; i < dp.length; i++) {
            // -1,-3 인덱스일때
            // tt 이면 f, ff이면 t 가 되는 형태임
            dp[i] = !dp[i - 1] || !dp[i - 3];
        }

        System.out.println(dp[N] ? "SK" : "CY");
    }
}
