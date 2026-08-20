import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    static int[] moveX = {-1, 0, 1, 0};
    static int[] moveY = {0, -1, 0, 1};
    
    private static int bfs(String[] board, int[] start) {
        Queue<int[]> q = new LinkedList<>();
        int n = board.length;
        int m = board[0].length();
        boolean[][] visited = new boolean[n][m];

        q.offer(new int[]{start[0], start[1], 0}); // 시작점( , ), 이동 횟수
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int moves = cur[2];

            if (board[x].charAt(y) == 'G') { // 2차원 배열이 아닌 문자열의 n번째 접근하는 방법을 사용!
                return moves;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;

                // 미끄러지기 : 벽이나 'D'를 만나기 전까지 계속 이동
                while (nx + moveX[i] >= 0 && nx + moveX[i] < n && ny + moveY[i] >= 0 && ny + moveY[i] < m &&
                        board[nx + moveX[i]].charAt(ny + moveY[i]) != 'D') {
                    nx += moveX[i];
                    ny += moveY[i];
                }

                // 방문하지 않은 최종 도착지점이라면 큐에 추가
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, moves + 1});
                }
            }
        }
        return -1;
    }

    public static int solution(String[] board) {
        int[] start = new int[2]; // 시작점

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'R') { // 시작점 저장
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        int answer = bfs(board, start);

        return answer;
    }
}