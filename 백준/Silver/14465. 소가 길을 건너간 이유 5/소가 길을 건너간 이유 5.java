import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 연속 K개
        int B = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        for (int i = 0; i < B; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[n - 1] = 1;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= N - K; i++) {
            int cnt = 0; // 고장난 신호등 수
            for (int j = 0; j < K && i + j < N; j++) {
                if (arr[i + j] == 1) {
                    cnt++;
                }
            }
            min = Math.min(min, cnt);
        }
        System.out.println(min);
    }
}