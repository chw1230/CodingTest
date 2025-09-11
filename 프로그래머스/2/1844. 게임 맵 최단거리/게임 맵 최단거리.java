import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    private static int[] moveX = {-1, 0, 1, 0};
    private static int[] moveY = {0, -1, 0, 1};
    private static int[][] dis; // 최단 거리를 담을 배열
    private static Deque<int[]> q;

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dis[i][j] = -1;
            }
        }

        if (maps[0][0] == 0) {
            return -1;
        }

        q = new ArrayDeque<>();
        dis[0][0] = 1; // 시작점의 최단 거리 1으로 처리하기
        q.addLast(new int[]{0, 0}); // y,x

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            if (y == n - 1 && x == m - 1) {
                return dis[y][x];
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + moveX[i];
                int newY = y + moveY[i];

                if ( -1 < newX && newX < m && -1 < newY && newY < n) {
                    if (maps[newY][newX] == 1 && dis[newY][newX] == -1) { // 길 이고 최단거리 갱신이 없는 경우에만
                        dis[newY][newX] = dis[y][x] + 1;
                        q.addLast(new int[]{newY, newX});
                    }
                }
            }
        }
        return -1;
    }
}