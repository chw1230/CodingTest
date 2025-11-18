import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        n = n % 7;
//        if (n == 1 || n == 3) {
//            System.out.println("CY");
//        } else {
//            System.out.println("SK");
//        }

        boolean[] dp = new boolean[1001];
        dp[1] = false;
        dp[2] = true;
        dp[3] = false;
        dp[4] = true;

        for (int i = 5; i <= n; i++) {
            dp[i] = !(dp[i - 1] && dp[i - 3] && dp[i - 4]); // i-1개 남기고 주기, i-3개 남기고 주기, i-4개 남기고 주기  => 이 경우가 모두 참이라면 상대방의 승리 인것! 그러면 나는 패배
        }

        System.out.println( dp[n] ? "SK" : "CY");
    }
}