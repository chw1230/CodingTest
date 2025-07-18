import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 넓이를 구하는 과정에서 오래걸림 + 오답 ....
// 왜 오래걸렸지? -> 아무것도 반환하지 않는 BFS와 static max를 통해서 해결하려고 했기 때문에
// + 배열에 넓이를 직접 매기며 배열의 값을 키우려고 했었음 그것 보다 배열을 방문 처리로 다루면서 반환값을 통해서 값을 구하는 게 더 잘풀리는 방법인 것 같음!

public class Main{
    static int n,m;
    static int moveY[] = {0, 0, -1, 1};
    static int moveX[] = {-1, 1, 0, 0};
    static int arr[][];

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }

    static int BFS(int x, int y) { // 넓이를 반환하도록 설정하기
        if (arr[y][x] == 0) {
            return 0;
        }
        int area = 1; // 그림의 넓이 변수, 하나만 있으면 넓이가 1이니까 기본 값을 1로 설정하기
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        arr[y][x] = 0; // 방문 처리하기

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = p.x + moveX[i];
                int newY = p.y + moveY[i];
                if (0 <= newX && newX < m && 0 <= newY && newY < n) {
                    if (arr[newY][newX] == 1) {
                        arr[newY][newX] = 0; // 방문 처리하기
                        q.add(new Point(newX, newY));
                        area++; // 넓이 키우기
                    }
                }
            }
        }
        return area;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로
        arr = new int[n][m];

        // 배열 생성
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0; // 그림의 개수
        int max = 0; // 최대 그림의 넓이
        for (int i = 0; i < n; i++) { // 세로
            for (int j = 0; j < m; j++) { // 가로
                int area = BFS(j, i);
                if ( area > 0 ) {
                    cnt++;
                    max = Math.max(max, area);
                }

            }
        }

        System.out.println(cnt + " " + max);
    }
}