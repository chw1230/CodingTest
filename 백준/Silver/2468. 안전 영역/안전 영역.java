import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 한번에 못맞춘 이유 <높이는 1이상 100 이하의 정수> -> 물의 높이의 범위가 정해져 있었는데 고려하지 않고, 물의 범위가 입력의 최소 값부터 최대 값까지인 줄 알았음!
    private static int N;
    private static int[][] arr;
    private static int[][] safe; // 0 -> 물 잠김, 1 -> 안전, -1 -> 방문 완료!
    private static int[] moveX = {-1, 1, 0, 0};
    private static int[] moveY = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }

        int r = Integer.MIN_VALUE;
        int cnt;
        for (int i = 0; i <= max; i++) {
            cnt = 0;
            safe = new int[N + 1][N + 1];
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (arr[j][k] > i) {
                        safe[j][k] = 1; // 안전 설정!
                    }
                }
            }

            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (safe[j][k] == 1) {
                        dfs(j, k);
                        cnt++;
                    }
                }
            }
            r = Math.max(r, cnt);
        }
        System.out.println(r);
    }

    private static void dfs(int y, int x) { // 안전 구역 좌표 전달 받기
        safe[y][x] = -1; // 방문 처리

        for (int i = 0; i < 4; i++) {
            int ny = y + moveY[i];
            int nx = x + moveX[i];
            if (1 <= ny && ny <= N && 1 <= nx && nx <= N) {
                if (safe[ny][nx] == 1) {
                    dfs(ny, nx);
                }
            }
        }
    }
}