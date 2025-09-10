import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[N]; // 입력이 들어가는 배열
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if ( N == 1 ){
            System.out.println(arr[0]);
            return;
        }

        int dp[] = new int[N]; // 합이 들어가는 배열
        /*
        ( 입력된 수 / dp[i-1]+입력된 수) 두개를 비교해서 큰 값을 dp[i]에 넣기
         */
        int max = dp[0] = arr[0]; // dp 중에서도 최대 값을 저장할 변수 max 생성
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max( arr[i], dp[i-1] + arr[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}