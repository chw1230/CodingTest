import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static char arr[][];
    static int mX[] = {-1, 1, 0, 0};
    static int mY[] = {0, 0, -1, 1};
    static int cnt = 0;
    static int visited[][];

    static void DFS(int x, int y) {
        if (visited[y][x] == 0) {
            visited[y][x] = 1; // 방문 처리
        } else {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + mX[i];
            int newY = y + mY[i];
            if (0 <= newX && newX < M && 0 <= newY && newY < N) {
                if (arr[newY][newX] == 'X') {
                    continue;
                } else {
                    if (arr[newY][newX] == 'P' && visited[newY][newX] == 0) {
                        cnt++;
                    }
                    DFS(newX, newY);
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];

        int x = 0, y = 0;
        for (int i = 0; i < arr.length; i++) {
            String s = br.readLine();
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'I') {
                    x = j;
                    y = i;
                }
            }
        }

        visited = new int[N][M];
        DFS(x, y);
        if (cnt == 0) {
            System.out.println("TT");
        }else {
            System.out.println(cnt);
        }
    }
}