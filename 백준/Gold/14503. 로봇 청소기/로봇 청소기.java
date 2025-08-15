import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 어려웠던 점 continue와 break의 적절한 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); // 방향, 0->n, 1->e, 2->s, 3->w

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int[] moveR = {-1, 0, 1, 0};
        int[] moveC = {0, 1, 0, -1};
        while (true) {
            if (arr[r][c] == 0) {
                arr[r][c] = 2; // 청소
                cnt++; // 청소 개수 올리기
            }

            boolean move = false;
            for (int i = 0; i < 4; i++) {
                // 시야 반시계 바꾸기
                d = (d + 3) % 4;
                int newR = r + moveR[d];
                int newC = c + moveC[d];

                if (arr[newR][newC] == 0) { // 청소 안한 곳이면
                    r = newR;
                    c = newC;
                    move = true;
                    break;
                }
            }

            if (move) continue;

            // 네 방향 모두 가지 못하면
            int backD = (d + 2) % 4; // 후진
            int backR = r + moveR[backD];
            int backC = c + moveC[backD];

            // 뒤가 벽이면 종료하기
            if (backR < 0 || backR >= N || backC < 0 || backC >= M || arr[backR][backC] == 1) {
                System.out.println(cnt);
                return;
            }

            // 벽이 아니라면 후진하기
            r = backR;
            c = backC;
        }
    }
}