import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int max;
    private static int arr[][];
    private static int moveX[] = {-1, 1, 0, 0,};
    private static int moveY[] = {0, 0, -1, 1};
    private static ArrayList<Point> list = new ArrayList<>();
    
    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private static void dfsWall(int count) {
        if (count == 3) {
            // 벽이 3개이면 BFS 실행( 넓이 구하기 )
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) { // 빈칸이라면
                    arr[i][j] = 1; // 벽을 세우기
                    dfsWall(count + 1); // 지금 벽을 세우고 다음 벽을 세우기
                    arr[i][j] = 0; // 지금 벽을 부시고 다음 벽을 세우기, 백트래킹
                }
            }
        }
    }

    private static void bfs() {
        int[][] tmp = new int[N][M]; // 벽을 세울 때마다 배열이 달리지니까 지금 세워진 3개의 벽을 반영한 tmp 배열 만들기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                 tmp[i][j] = arr[i][j];
            }
        }

        Queue<Point> q = new ArrayDeque<>();
        // 바이러스 위치를 큐에 모두 추가하기
        for (Point virus : list) {
            q.add(virus);
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + moveX[i];
                int ny = p.y + moveY[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M && tmp[nx][ny] == 0) { // 방문했다면 2가 되기에 0만 방문하도록 하기(그리고 벽(1)인 경우도 자동으로 안 가도록)
                    tmp[nx][ny] = 2; //
                    q.add(new Point(nx, ny));
                }
            }
        }

        int area = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 0) {
                    area++; // 넓이 구하기
                }
            }
        }
        
        max = Math.max(max, area);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    // 바이러스 좌표들 저장하기
                    list.add(new Point(i, j));
                }
            }
        }

        max = 0;
        dfsWall(0);
        System.out.println(max);

    }
}