import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    
    static int[] moveX = {-1, 0, 1, 0};
    static int[] moveY = {0, -1, 0, 1};
    
    public static int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        bfs(visited, maps);

        int answer;
        if (maps[maps.length - 1][maps[0].length - 1] == 1) {
            answer = -1;
        } else {
            answer = maps[maps.length - 1][maps[0].length - 1];
        }
        return answer;
    }

    private static void bfs(boolean[][] visited, int[][] maps) {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{0, 0}); // 시작점 좌상단
        visited[0][0] = true; // 시작점 방문 처리

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                // 다음 이동할 좌표
                int nextX = curX + moveX[i];
                int nextY = curY + moveY[i];

                // 범위 벗어나면 패스
                if (nextX < 0 || nextY < 0 || nextX >= maps.length || nextY >= maps[0].length) {
                    continue;
                }

                if (!visited[nextX][nextY] && maps[nextX][nextY] == 1) {
                    queue.add(new int[]{nextX, nextY}); // q에 넣기
                    visited[nextX][nextY] = true; // 방문 처리
                    maps[nextX][nextY] = maps[curX][curY] + 1;
                }
            }
        }
    }
}