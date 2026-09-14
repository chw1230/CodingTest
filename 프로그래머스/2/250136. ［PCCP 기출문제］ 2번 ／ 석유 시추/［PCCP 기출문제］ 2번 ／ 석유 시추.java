
import java.util.*;

class Solution {
    static int[] movex = {-1, 1, 0, 0};
    static int[] movey = {0, 0, -1, 1};
    static boolean[][] visited;
    static int n, m;

      public static int solution(int[][] land) {
        n = land.length; // 세로 길이 (행)
        m = land[0].length; // 가로 길이 (열)
        visited = new boolean[n][m];

        int[] c = new int[m]; // 각 idx에는 해당되는 idx 일때의 가지는 오일 사이즈가 저장이 됨!

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    visited[i][j] = true;
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.add(new int[]{i, j});

                    // 석유가 있는 위치를 담는 리스트
                    List<int[]> group = new ArrayList<>();
                    // 석유가 있는 열들을 담을 set
                    Set<Integer> cols = new HashSet<>();

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        group.add(cur); // 위치를 저장
                        cols.add(cur[1]); // 열들을 저장

                        int row = cur[0];
                        int col = cur[1];

                        for (int k = 0; k < 4; k++) {
                            int newRow = row + movex[k];
                            int newCol = col + movey[k];

                            if (newRow < 0 || newCol < 0 || newRow >= n || newCol >= m) {
                                continue;
                            }
                            if (!visited[newRow][newCol] && land[newRow][newCol] == 1) {
                                visited[newRow][newCol] = true;
                                queue.add(new int[]{newRow, newCol});
                            }
                        }
                    }
                    // 만약에 오일로 시작했다면 쭉 오일인게 저장되면 오일으 사이즈를 알 수 있음!
                    int size = group.size();

                    // 오일이 잇는 곳의 열의 위치를 저장
                    for (Integer col : cols) {
                        // 그 열들에 오일의 사이즈를 더해주기
                        c[col] += size;
                    }
                }
            }
        }

        int max = 0;
        for (int oil : c) {
            max = Math.max(max, oil);
        }
//        System.out.println(max);

        return max;
    }     
}