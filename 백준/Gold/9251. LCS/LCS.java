import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 부분 수열이란? -> 어떤 문자열에서 순서를 지키면서(좌에서 시작하면 우로 끝까지, 중간에 빠꾸 없음!) 문자를 골라낸 것
    // 특징 : 문자를 반드시 연속해서 고를 필요없음! 중간중간 건너뛰기 가능! / 반드시 연속된 문자열은 부분 문자열이라고 부름!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        // 공백 문자를 고려해서 생성하기 ["",a,b,d . . .] 이렇게
        char[] ch1 = new char[s1.length() + 1];
        ch1[0] = 0; // 공백 문자 대신에 '\0'을 넣기
        for (int i = 1; i < s1.length()+1; i++) {
            ch1[i] = s1.charAt(i-1);
        }

        // 공백 문자를 고려해서 생성하기 ["",a,b,d . . .] 이렇게
        char[] ch2 = new char[s2.length() + 1];
        ch2[0] = 0;
        for (int i = 1; i < s2.length() + 1; i++) {
            ch2[i] = s2.charAt(i-1);
        }

        int max = 0;
        int[][] dp = new int[ch1.length][ch2.length]; // 최장 공통 부분 수열의 길이를 가지는 배열

        // ch1 배열과 ch2 배열을 사용해서 최장 공통 부분 수열 찾기
        // ch1 배열을 가장 좌측 기준 열로 두고 사용, ch2 배열을 가장 상단 기준 행으로 두고 사용
        // 실제 문자가 있는 부분부터 돌기
        for (int i = 1; i < ch1.length; i++) {
            for (int j = 1; j < ch2.length; j++) {
                if (ch1[i] == ch2[j]) { // 같으면 공통 부분 수열 추가하기( -> +1로 추가해주는 작업 )
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { // 둘이 다르면 기존의 숫자들 중 큰수를 통해서 공통 부분 수열 개수 유지하기 -> 그래야 최장 공통 부분 수열을 찾을 수 있음!
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }
}