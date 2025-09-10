import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine()); // 층
            int N = Integer.parseInt(br.readLine()); // 호
            int[][] arr = new int[K+1][N+1];

            // 0층 초기화
            for (int j = 1; j <= N; j++) {
                arr[0][j] = j;
            }

            // 점화식 세워서 풀기
            for (int j = 1; j <= K; j++) {
                for (int k = 1; k <= N; k++) {
                    arr[j][k] = arr[j-1][k] + arr[j][k-1]; // 같은 층의 옆집 + 아래 층의 같은 호 로 구성
                }
            }
            System.out.println(arr[K][N]);
        }
    }
}