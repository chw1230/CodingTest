import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int INF = 10_001;

        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[INF][4];
        // dp[n][k] => n을 1,2,3의 합으로 나타내면서, 마지막에 k를 사용한 경우의 수를 저장하기

        // 초기값 설정
        dp[1][1] = 1; // 1 = 1

        dp[2][1] = 1; // 2 = 1 + 1
        dp[2][2] = 1; // 2 = 2

        dp[3][1] = 1; // 3 = 1 + 1 + 1
        dp[3][2] = 1; // 3 = 1 + 2
        dp[3][3] = 1; // 3 = 3

        for (int i = 4; i < INF; i++) {
            // 1을 마지막으로 사용하면, 앞에는 무조건 1만 있어야 함 ex> 1 + ... + 1 '+ 1'
            dp[i][1] = dp[i - 1][1];

            // 2를 마지막으로 사용하면, 앞에는 1 또는 2만 올 수 있음
            // dp[i - 2][1] => i번 수보다 2만큼 작은 수가 1로만 나타냈다면 마지막에 2더해주면 됨!
            // dp[i - 2][2] => i번 수보다 2만큼 작은 수를 나타낸 마지막 수가 2이라면 마지막에 2더해주면 됨!
            // 그래서 i보다 2 작은 수를 표현할 때 마지막에 1을 사용한 경우와 2를 사용한 경우를 더하기
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];

            // 3을 마지막으로 사용하면, 앞에는 1,2,3 모두 가능
            // dp[i - 3][1] => i번 수보다 3만큼 작은 수가 1로만 나타냈다면 마지막에 3더해주면 됨!
            // dp[i - 3][2] => i번 수보다 3만큼 작은 수를 나타낸 마지막 수가 2이라면 마지막에 3더해주면 됨!
            // dp[i - 3][3] => i번 수보다 3만큼 작은 수를 나타낸 마지막 수가 3이라면 마지막에 3더해주면 됨!
            // 그래서 i보다 3 작은 수를 표현할 때 마지막에 1을 사용한 경우와 2를 사용한 경우, 3을 사용한 경우를 더하기
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
        }
    }
}