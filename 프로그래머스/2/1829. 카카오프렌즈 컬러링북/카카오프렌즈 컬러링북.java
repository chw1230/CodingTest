import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] moveR = {-1,1,0,0};
    static int[] moveL = {0,0,-1,1};
    static boolean[][] visited;

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    numberOfArea++; // 그림 영역의 수++
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, picture)); // 가장 넓은 그림을 찾기
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private static int bfs(int i, int j, int[][] picture) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        visited[i][j] = true;
        int sum = 1; // 넓이의 합!

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int color = picture[point[0]][point[1]];

            for (int k = 0; k < 4; k++) {
                int newX = point[0] + moveR[k];
                int newY = point[1] + moveL[k];

                if ( newX < 0 || newY < 0 || picture.length <= newX || picture[0].length <= newY) {
                    continue;
                }

                // 방문 경험 X, 같은 색상 일떄만 q에 넣기
                if ( !visited[newX][newY] && picture[newX][newY] == color) {
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                    sum++;
                }
            }
        }
        return sum;
    }
}