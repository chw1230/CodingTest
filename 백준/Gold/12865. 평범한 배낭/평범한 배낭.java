import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] w = new int[N];
        int[] v = new int[N];

        int[] dp = new int[K+1]; //  무게가 idx에 담을 수 있는 가장 큰 가치를 담는 배열
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) { // 물건 i
            for (int weight = K; weight >= w[i]; weight--) { // 무게는 배낭에 담았을 때 배낭의 무게 조건을 넘어서면 안됨
                dp[weight] = Math.max(dp[weight], dp[weight - w[i]] + v[i]);  // weight 일때의 최대 가치(안담는 경우)와 i 물건을 배낭에 담았을 때의 최대 가치(담는 경우)를 비교해서 큰 것 을 담기
            }
        }
        System.out.println(dp[K]);
    }
}