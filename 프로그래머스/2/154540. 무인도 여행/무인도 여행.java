

import java.util.ArrayList;
class Solution {
    static int[] moveR = new int[]{-1, 0, 1, 0};
    static int[] moveL = new int[]{0, -1, 0, 1};
    static boolean[][] visited;
    static char[][] grid;

    // public static void main(String[] args) {
    //     solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"});
    // }

    public static int[] solution(String[] maps) {
        ArrayList<Integer> list = new ArrayList<>();
        int rows = maps.length;
        int cols = maps[0].length();
        visited = new boolean[rows][cols];
        grid = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            grid[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] != 'X') {
                    list.add(dfs(i, j, rows, cols));
                }
            }
        }

        if (list.isEmpty()) {
            list.add(-1);
        }

        return list.stream().sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static int dfs(int i, int j, int rows, int cols) {
        visited[i][j] = true;
        int sum = grid[i][j] - '0'; // 현재 값을 sum에 더하기

        for (int k = 0; k < 4; k++) {
            int newR = i + moveR[k];
            int newL = j + moveL[k];

            if (0 <= newR && 0 <= newL && newR < rows && newL < cols) {
                if (!visited[newR][newL] && grid[newR][newL] != 'X') {
                    sum += dfs(newR, newL, rows, cols);
                }
            }
        }
        return sum;
    }
}