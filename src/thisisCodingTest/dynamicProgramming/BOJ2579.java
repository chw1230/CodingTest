package thisisCodingTest.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N+1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) { // N 1이면 dp[2] 라는 것은 있을 수 없기에 1인 경우 score[1] 출력해주기!
            System.out.println(score[1]);
            return;
        }
        // 처음 값 초기화
        dp[1] = score[1];
        dp[2] = score[1] + score[2];

        // 3번 부터 고려해야함!
        // 1번을 밟고 3을 밟을지
        // 2를 밟고 3을 밟을 지
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2],dp[i - 3] + score[i - 1]) + score[i];
        }
        System.out.println(dp[N]);
    }
    /*
    처음에 문제를 틀린 이유 -> 3칸 연속 오르기 불가능 하게 하는 방법 고려하지 못함!
    그렇다면 3칸 연속 오르기 못하게 하는 방법은?
    dp가 각 계단을 밟을 때 최댓값을 의미! 그러므로 i-3을 통해서 i의 3개 아래 칸에 max값에 score[i - 1]값을 더하는 것!
    그러면 3칸 전꺼를 밟고 2칸 오르고(i 기준 1칸 전) 1칸을 밟는것(여기가 i칸을 의미함)
     */
}
