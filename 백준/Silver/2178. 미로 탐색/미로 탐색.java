import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int arr[][];
    static int moveX[] = {-1, 1, 0, 0};
    static int moveY[] = {0, 0, -1, 1};

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y)); // 시작점 큐에 넣고 시작하기

        while(!q.isEmpty()) { // 큐가 빌때까지 
            Point p = q.poll(); // 큐에서 뺴기
            for (int i = 0; i < 4; i++) { // move
                int newX = p.x + moveX[i]; 
                int newY = p.y + moveY[i];
                if (0 <= newX && newX < M && 0 <= newY && newY < N) { // 배열 속 범위 일떄만 동작하도록 하기
                    if (arr[newY][newX] == 1) { //미로 가야하는 길인 1일때만 작동하도록!
                        arr[newY][newX] += arr[p.y][p.x]; // 지금까지 왔던 길을 더해가기
                        q.offer(new Point(newX, newY)); // 큐에 추가
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) { // 배열 생성
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        BFS(0, 0);

//        for (int i = 0; i < N; i++) { // 배열 출력
//            for (int j = 0; j < M; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }

        System.out.println(arr[N - 1][M - 1]); // 최종 위치의 값 출력
    }
}