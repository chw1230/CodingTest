import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // 오답 이유 : dp[i][j]가 max 보다 큰 경우에 list에 넣는 방식으로 해결 -> 실제 LCS와 맞지 않는 문제 발생
    // s1="CAB", s2="ABC" 이라면 내가 한 방식 대로라면 "CB" 가 나오게됨! 실제 LCS는 "AB" 그래서 맞지 않음
    // 해결 방법 : dp를 통해 완성된 것에서 거꾸로 가며 LCS의 정보가 담긴 곳에서 문자를 가져오기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        char c1[] = new char[s1.length() + 1];
        char c2[] = new char[s2.length() + 1];

        c1[0] = '0';
        c2[0] = '0';
        for (int i = 1; i < c1.length; i++) {
            c1[i] = s1.charAt(i - 1);
        }
        for (int i = 1; i < c2.length; i++) {
            c2[i] = s2.charAt(i - 1);
        }

        List<Character> list = new ArrayList<>();
        int dp[][] = new int[c1.length][c2.length];
        for (int i = 1; i < c1.length; i++) {
            for (int j = 1; j < c2.length; j++) {
                if (c1[i] == c2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[c1.length - 1][c2.length - 1]);
        if (dp[c1.length - 1][c2.length - 1] == 0) {
            return;
        }

        int i = c1.length - 1;
        int j = c2.length - 1;
        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (c1[i] == c2[j]) { // 일치하면
                sb.append(c1[i]); // 가져오기
                i--;
                j--;
            } else {
                if (dp[i - 1][j] >= dp[i][j - 1]) {
                    i--; // 큰 것을 따라가도록!
                } else {
                    j--;
                }
            }
        }
        System.out.println(sb.reverse().toString());
    }
}