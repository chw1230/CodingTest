import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
     *  - i번째 날에 할 수 있는 선택은 두 가지
     * 1) i번째 날의 상담을 '한다.'
     * 2) i번째 날의 상담을 '하지 않는다.'
     *  - 이 두 선택 중 더 큰 수익을 주는 쪽을 dp[i]에 저장 하도록 하기
     * 그리고 우리가 또 신경 써야 할 것 i 날에 일을 한다면 끝나는 날(i + T[i])이 N+1보다 크지 않은지 확인해야함!!
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 2]; // idx 날 부터 퇴사일(N)까지 벌수 있는 최대 수익을 저장하는 배열
        int[] T = new int[N + 2];
        int[] P = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 끝나는 날이 미래에 정해져 있음, 그리고 끝나는 날까지 최적의 선택을 해야하기위해서는 미래의 결과를 알아야 결정할 수 있기 때문에 뒤에서 부터 앞으로 계산
        for (int i = N; i >= 1; i--) {
            int next = i + T[i];
            if (next > N + 1) { // i날에 일하면 퇴사일을 넘어가는 경우 일 수행이 불가능
                dp[i] = dp[i + 1]; // 일 하지 않고, 다음 날 벌 수 있는 수익을 그대로 가져오기
            } else {
                // 상담을 하고, 안하고 둘 중 큰 값을 저장하기!!!
                // 상담을 하는 경우 => i일 벌어드리는 수익(P[i]) + i일에 상담이 끝난 다음날(next(i + T[i]))부터 벌 수 있는 최대 수익(dp[next])
                // 상담을 안하는 경우 => i+1일부터 벌수 있는 최대 수익
                // 둘을 비교해서 i날 가장 크게 얻을 수 있는 수익을 저장하기
                dp[i] = Math.max(P[i] + dp[next], dp[i + 1]);
            }
        }

        System.out.println(dp[1]);
    }
}