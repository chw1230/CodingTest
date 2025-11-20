import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 1_000_000_000;

        long[][] dp = new long[N + 1][10]; // 계단수, 각 인덱스 수로 시작하는 숫자의 개수

        for (int i = 0; i <= 9; i++) { // 계단 수가 1인 경우에는 각 인덱스 수로 시작하는 숫자의 개수들이 모두 1개
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) { // 0으로 시작하는 경우
                    dp[i][0] = dp[i - 1][1] % max; // 이전 계단 수에서 1로 시작하는 수에 가장 좌측에 0만 추가 하면 되니까!
                    // 이전 계단수의 1로 시작하는 수의 개수 그래도 가져오면 됨!
                } else if (j == 9) { // 9로 시작하는 경우
                    dp[i][9] = dp[i - 1][8] % max; // 이전 계단 수에서 8로 시작하는 수에 가장 좌측에 9만 추가 하면 되니까!
                    // 이전 계단수의 8로 시작하는 수의 개수 그대로 가져오면 됨!
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] % max + dp[i - 1][j + 1] % max) % max;
                    // 이전 계단수의 하나 낮은 수에 가장 좌측에 j를 붙이는 경우 +
                    // 이전 계단수의 하나 높은 수의 가장 좌측에 j를 붙이는 경우
                }
            }
        }

        long sum = 0;
        for (int i = 1; i <= 9; i++) {
            sum = ( sum + dp[N][i] ) % max;
        }
        System.out.println(sum % max);
    }
}