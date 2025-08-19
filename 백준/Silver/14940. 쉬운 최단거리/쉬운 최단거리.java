import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static int[][] arr;
    private static int[][] visited;
    private static int[] moveX = {-1, 1, 0, 0};
    private static int[] moveY = {-0, 0, -1, 1};
    private static Queue<int[]> q = new LinkedList<>();

    static void BFS(int y, int x) {
        arr[y][x] = 0;
        q.add(new int[] { y, x }); //q에 넣기

        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int i = 0; i < 4; i++) {
                int newY = current[0] + moveY[i];
                int newX = current[1] + moveX[i];
                if ( 0 <= newX && newX < m && 0 <= newY && newY < n ) {
                    if (arr[newY][newX] != 0 && visited[newY][newX] == 0) {
                        visited[newY][newX] = 1; // 방문 처리의 시점과 어떤 것을 방문 처리 해야하는 지를 신경쓰자!
                        q.add(new int[] { newY, newX });
                        arr[newY][newX] = arr[current[0]][current[1]] + 1;
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 0 -> 못가는 땅, 1 -> 갈 수 있는 땅, 2 -> 목표 지점
        int x = 0;
        int y = 0;
        arr = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) { // 목표 지점 저장하기
                    y = i;
                    x = j;
                }
            }
        }

        BFS(y, x);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && visited[i][j] == 0) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}