import java.util.*;

class Solution {
    static int[] moveR = new int[]{-1, 0, 1, 0};
    static int[] moveL = new int[]{0, -1, 0, 1};
    static boolean[][] visited;
    static char[][] grid;

    // bfs로 풀기
    public static int[] solution(String[] strings) {
        int n = strings.length;
        int m = strings[0].length();
        grid = new char[n][m];
        ArrayList<Integer> list = new ArrayList<>();

        // grid 채우기
        for (int i = 0; i < n; i++) {
            String string = strings[i];
            for (int j = 0; j < m; j++) {
                grid[i][j] = string.charAt(j);
            }
        }

        visited = new boolean[n][m];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 'X' && !visited[i][j]) {
                    // bfs 출발~!
                    list.add(bfs(i, j, grid));
                }
            }
        }
        Collections.sort(list);
        
         if (list.size() == 0) {
            return new int[]{-1};
        } 
        
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static int bfs(int i, int j, char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true; // 방문처리

        int sum = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            sum += grid[poll[0]][poll[1]] - '0';

            for (int k = 0; k < 4; k++) {
                int newI = poll[0] + moveR[k];
                int newJ = poll[1] + moveL[k];

                if (newI < 0 || newJ < 0 || grid.length <= newI || grid[0].length <= newJ) {
                    continue;
                }

                if (!visited[newI][newJ] && grid[newI][newJ] != 'X') {
                    queue.add(new int[]{newI, newJ});
                    visited[newI][newJ] = true; // 방문처리
                }
            }
        }
        return sum;
    }

    //    public static int[] solution(String[] maps) {
//        ArrayList<Integer> list = new ArrayList<>();
//        int rows = maps.length;
//        int cols = maps[0].length();
//        visited = new boolean[rows][cols];
//        grid = new char[rows][cols];
//
//        for (int i = 0; i < rows; i++) {
//            grid[i] = maps[i].toCharArray();
//        }
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (!visited[i][j] && grid[i][j] != 'X') {
//                    list.add(dfs(i, j, rows, cols));
//                }
//            }
//        }
//
//        if (list.isEmpty()) {
//            list.add(-1);
//        }
//
//        System.out.println(list);
//
//        return list.stream().sorted()
//                .mapToInt(Integer::intValue)
//                .toArray();
//    }
//
//    private static int dfs(int i, int j, int rows, int cols) {
//        visited[i][j] = true;
//        int sum = grid[i][j] - '0'; // 현재 값을 sum에 더하기
//
//        for (int k = 0; k < 4; k++) {
//            int newR = i + moveR[k];
//            int newL = j + moveL[k];
//
//            if (0 <= newR && 0 <= newL && newR < rows && newL < cols) {
//                if (!visited[newR][newL] && grid[newR][newL] != 'X') {
//                    sum += dfs(newR, newL, rows, cols);
//                }
//            }
//        }
//        return sum;
//    }
}