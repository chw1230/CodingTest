import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static int max = Integer.MIN_VALUE;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int[][] arr;
    private static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                visited[i][j] = false;
            }
        }
        System.out.println(max);
    }

    private static void dfs(int r, int c, int sum, int cnt) {
        if (cnt == 4) { // 종료 조건
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nR = r + dx[i];
            int nC = c + dy[i];

            if (!inRange(nR, nC)) {
                continue;
            }

            if (!visited[nR][nC]) {
                if (cnt == 2) {
                    visited[nR][nC] = true; // 새로 붙일 블럭을 방문 처리
                    dfs(r, c, sum + arr[nR][nC], cnt + 1); // 바뀌지 않는 위치에서 다른 방향으로 칸을 하나 붙이기
                    visited[nR][nC] = false;
                }

                visited[nR][nC] = true;
                dfs(nR, nC, sum + arr[nR][nC], cnt + 1);
                visited[nR][nC] = false;
            }
        }
    }

    private static boolean inRange(int nR, int nC) {
        if (0 <= nR && nR < n && 0 <= nC && nC < m) {
            return true;
        }
        return false;
    }
}