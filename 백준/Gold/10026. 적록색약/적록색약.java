import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static char color[][];
    private static int visited[][];
    private static int moveX[] = {1, -1, 0, 0};
    private static int moveY[] = {0, 0, 1, -1};

    private static void DFS(int y, int x) {
        visited[y][x] = 1; // 방문 처리

        for (int i = 0; i < 4; i++) {
            int newX = x + moveX[i];
            int newY = y + moveY[i];
            if (-1 < newX && newX < N && -1 < newY && newY < N) {
                if (visited[newY][newX] == 0) {
                    if (color[newY][newX] == color[y][x]) {
                        DFS(newY, newX);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        color = new char[N][N];
        visited = new int[N][N];
        char[][] newArr = new char[N][N]; // 적녹 생약을 위한 배열
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                color[i][j] = str.charAt(j);
                if ( color[i][j] == 'G') {
                    newArr[i][j] = 'R';
                } else {
                    newArr[i][j] = color[i][j];
                }
            }
        }

        int result[] = new int[2]; // 비적녹 생약, 적녹 색약
        for (int k = 0; k < 2; k++) {
            if (k == 1) {
                color = newArr;
                visited = new int[N][N];
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0) {
                        DFS(i, j);
                        result[k]++;
                    }
                }
            }
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}