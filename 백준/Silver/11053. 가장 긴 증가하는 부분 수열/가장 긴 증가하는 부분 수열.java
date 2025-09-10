import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 처음에 시뮬레이션? 형식으로 시도 -> 진짜 고생했는데 오답.....
    // dp로 시도하기...
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N]; // input 숫자를 담을 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int dp[] = new int[N]; // 길이 값을 저장할 배열 만들기
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1; // 일단 기본으로 1 설정 -> 처음 시작하는 경우와 10-20-10 이렇게 늘어나다가 줄어드는 경우 카운트 하기 위해서

            for (int j = 0; j < i; j++) {
                if ( arr[j] < arr[i]) { // 길이를 계속 늘려 나가야 하는 경우 -> 이전 dp 값에 1 더하기
                    dp[i] = Math.max(dp[i], dp[j] + 1); 
                    // dp[i], dp[j] + 1의 최대 값을 비교하는 이유 -> 그냥 dp[i] = dp[j] + 1을 사용하면 최대값으로 설정이 되었다가
                    // 다시 dp[j] = 1이라면 다시 dp[i]의 값이 작아짐!! 최개 값으로 유지하기 위해서!!
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}