import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int M;
    private static int N;
    private static int H;
    private static int arr[][][]; // z y x
    private static Queue<int []> q = new LinkedList<>();
    private static int moveX[] = {0, 0, 0, 0, -1, 1}; // 무브 무브!
    private static int moveY[] = {0, 0, -1, 1, 0, 0};
    private static int moveZ[] = {-1, 1, 0, 0, 0, 0};
    private static int max = Integer.MIN_VALUE;

    private static void BFS() {
        while (!q.isEmpty()) {
            int[] save = q.poll();
            int z = save[0];
            int y = save[1];
            int x = save[2];

            for (int i = 0; i < 6; i++) {
                int newZ = z + moveZ[i];
                int newY = y + moveY[i];
                int newX = x + moveX[i];

                if ( 0 <= newZ && newZ < H && 0 <= newY && newY < N && 0 <= newX && newX < M ) {
                    if (arr[newZ][newY][newX] == 0) {
                        q.offer(new int[]{newZ, newY, newX});
                        arr[newZ][newY][newX] = arr[z][y][x] + 1;
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 쌓아올려지는 상자의 수

        arr = new int[H][N][M];

        int flag = 0; // 익은 토마토 없는 경우 걸러네기 위한 변수
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    arr[h][n][m] = Integer.parseInt(st.nextToken());
                    if (arr[h][n][m] == 1) { // 시작점 담기
                        q.add(new int [] {h, n, m});
                    } else if (arr[h][n][m] == 0) {
                        flag = 1;
                    }
                }
            }
        }

        if (flag == 0) {
            System.out.println(flag);
            return;
        }

        BFS();

        for (int[][] ints : arr) {
            for (int[] anInt : ints) {
                for (int i : anInt) {
                    if (i == 0) {
                        System.out.println(-1);
                        return;
                    } else {
                        max = Math.max(max, i);
                    }
                }
            }
        }
        System.out.println(max-1);
    }
}