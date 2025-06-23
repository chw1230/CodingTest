import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[][];
    // 좌측 하단 대각, 좌측,좌측 상단 대각, 우측 하단 대닥, 우측, 우측 상단 대닥,아래,위에 -> 8가지 경우
    static int moveX[] = {-1, -1,-1, 1, 1, 1, 0, 0};
    static int moveY[] = {-1, 0, 1, -1, 0, 1,-1,1};
    static int w;
    static int h;

    static boolean DFS(int x, int y) {
        if (x <0 || y<0 || x>= w || y>= h){ // 범위 벗어나기 조절
            return false;
        }

        if (arr[y][x] == 1) {
            arr[y][x]++; // 방문 흔적 남기기
            for (int i = 0; i < 8; i++) {
                DFS(x+moveX[i], y+moveY[i]);
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken()); // 너비(가로)
        h = Integer.parseInt(st.nextToken()); // 높이(세로)
        while (w != 0 && h != 0) {
            arr = new int[h][w];

            // arr 완성하기
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    if (DFS(x, y)) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);

            // 다음거 입력받기
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // 너비(가로)
            h = Integer.parseInt(st.nextToken()); // 높이(세로)
        }
    }
}