import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 플로이드 워셀로 갈 수 있는지를 파악하고, 갈 수 있음을 처리(ture)
    // i가 가리키는게 true거나 i가 가림킨 당하는게 true 라면 둘중에 하나만 true여도 cnt 올리기
    // 최종적으로 cnt가 N-1 이라면(본인 제외니까) 연결 관계에 대해서 다 안다는 거니까 -> 순서를 매길 수 있다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] graph = new boolean[N + 1][N + 1]; // 갈 수 있는 지 여부를 담을 수 있은 2차워 배열

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = true;
        }

        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    if (graph[a][k] && graph[k][b]) {
                        graph[a][b] = true;
                    }
                }
            }
        }
        
        int r = 0;
        for (int i = 1; i <= N; i++) {
            int cnt = 0;

            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }

                if (graph[i][j] || graph[j][i]) { // 가리키거나, 가리킴 당하고 있으면 순서 파악 가능
                    cnt++;
                }
            }

            if (cnt == N - 1) {
                r++;
            }
        }
        System.out.println(r);
    }
}