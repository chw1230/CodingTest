package thisisCodingTest.dynamicProgramming;

import java.io.IOException;
import java.util.Scanner;

public class AntWarrior {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }

        // 인덱스 번호까지의 얻을 수 있는 최대값을 넣을 dp 리스트
        int[] dp = new int[1001];
        dp[0] = num[0];
        dp[1] = Math.max(num[0], num[1]);
        // dp[1]을 이렇게 구하는 이유 -> 최댓값을 구하는 것이 목적이므로
        // 인덱스가 1일때 값이 더 크면 -> dp[1]에 그걸 넣고
        // 인덱스가 0일때 값이 더 크면 -> dp[1]에 기존의 값을 한번더 넣어줌 -> 즉 dp[0]을 선택한 상황인 것!

        for (int i = 2; i < N; i++) { // 2부터 N까지
            // 최대값을 비교하는 대상을 이렇게 선정한 이유!
            // dp[i-1]와 dp[i - 2] + num[i]를 비교하는 이유
            // 일단 dp[i-1]이 더 크다면 dp[i]가 dp[i-1]가 되면서 최댓값을 구하기 위해 처름 값을 다시 구하는 과정이된다.
            // dp[i - 2] + num[i]가 더 크다면 i 위치보다 좌측에 2칸 더 떨어져 있던 값에 i번째 입력된 수를 더해준다. -> 기존에 큰 값에 큰 값을 더해가는 과정
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + num[i]);
        }
        System.out.println(dp[N - 1]);

        // 처음에 dp 배열을 어떤 값을 담을 건지 설정하는 것이 가장 중요한 것 같음!
        // 그 다음에는 점화식을 어떤식으로 세워서 dp[] 속 값들을 어떻게 비교 할 것 인지 생각하는 것이 중요한 것 같음!
    }
}
