package 삼성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 방화벽설치하기 {
    static int n;
    static int m;
    static int max;
    static int moveR[] = {-1, 1, 0, 0,};
    static int moveC[] = {0, 0, -1, 1};
    static int[][] arr;
    static ArrayList<Position> fireList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    // 불의 위치를 저장
                    fireList.add(new Position(i, j));
                }
            }
        }

        max = 0;
        wall(0);
        System.out.println(max);
    }

    // 빈 칸 중 3곳을 골라 벽을 세우는 모든 경우를 탐색하기
    private static void wall(int i) {
        if (i == 3) {
            bfs();
            return;
        }

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                if (arr[j][k] == 0) {
                    arr[j][k] = 1; // 벽 세우기
                    wall(i + 1);
                    arr[j][k] = 0; // 벽 세운거 없애기
                }
            }
        }
    }


    private static void bfs() {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) { // 벽을 세운 상태에서의 배열을 복사
            for (int j = 0; j < m; j++) {
                tmp[i][j] = arr[i][j];
            }
        }

        Queue<Position> q = new ArrayDeque<>();
        // 불의 위치를 전부 추가
        for (Position position : fireList) {
            q.add(position);
        }

        while (!q.isEmpty()) {
            Position p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + moveR[i];
                int nc = p.c + moveC[i];

                if (0 <= nr && nr < n && 0 <= nc && nc < m && tmp[nr][nc] == 0) {
                    // arr[nr][nc] = 0 이라면 -> 불도 벽도 아닌 상태!
                    tmp[nr][nc] = 2; // 불 번지기
                    q.add(new Position(nr, nc)); // 불의 위치를 담는 q에 넣기
                }
            }
        }

        int area = 0; // 안전한 구간 정하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 0) {
                    area++;
                }
            }
        }
        max = Math.max(max, area);
    }

    static class Position {
        int r;
        int c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
