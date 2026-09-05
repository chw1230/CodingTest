import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    static boolean[][] visited;
    static int[] moveR = {-1, 0, 1, 0};
    static int[] moveC = {0, -1, 0, 1};
    
    public static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            char[][] board = new char[5][5];
            for (int j = 0; j < 5; j++) {
                board[j] = places[i][j].toCharArray();
            }

            if ( isRoom(board) ) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }

        }

//        for (int i : answer) {
//            System.out.println(i);
//        }

        return answer;
    }

    public static boolean isRoom(char[][] board) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (board[r][c] == 'P') {
                    if (!bfs(r, c, board)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean bfs(int r, int c, char[][] board) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c, 0}); // r,c,0
        boolean[][] visited = new boolean[5][5];
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[2] >= 2)  { // 맨해튼 거리 2까지만 보기!
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + moveR[i];
                int nc = cur[1] + moveC[i];

                if (nr < 0 || nc < 0 || 5 <= nr || 5 <= nc) {
                    continue;
                }

                if (!visited[nr][nc] && (board[nr][nc] != 'X')) {
                    // 맨해튼 거리 2안 쪽까지만 보는 과정에서 P가 보이면 false 반환
                    if (board[nr][nc] == 'P') {
                        return false;
                    }
                    q.add(new int[]{nr, nc, cur[2] + 1});
                    visited[nr][nc] = true;
                }
            }
        }
        return true;
    }
}