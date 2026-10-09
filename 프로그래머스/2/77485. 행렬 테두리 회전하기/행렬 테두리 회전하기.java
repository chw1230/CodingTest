class Solution {
    public static int[] solution(int rows, int columns, int[][] queries) {
        int r[] = new int[queries.length];
        int cnt = 0;
        int arr[][] = new int[rows][columns];

        int n = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = n++;
            }
        }

        for (int[] query : queries) {
            int startRow = query[0] - 1;
            int startCol = query[1] - 1;
            int endRow = query[2] - 1;
            int endCol = query[3] - 1;

            // 시계방향이동
            // 우상단으로 이동
            int tmp = arr[startRow][startCol];
            int tmp2 = 0;
            int min = tmp;
            for (int i = startCol; i <= endCol; i++) {
                // startRow로 고정
                tmp2 = arr[startRow][i];
                arr[startRow][i] = tmp;
                tmp = tmp2;
                min = Math.min(min, tmp);
            }

            // 우하단으로 이동
            for (int i = startRow + 1; i <= endRow; i++) {
                tmp2 = arr[i][endCol];
                arr[i][endCol] = tmp;
                tmp = tmp2;
                min = Math.min(min, tmp);
            }

            // 좌하단으로 이동
            for (int i = endCol - 1; i >= startCol; i--) {
                tmp2 = arr[endRow][i];
                arr[endRow][i] = tmp;
                tmp = tmp2;
                min = Math.min(min, tmp);
            }

            // 좌상단으로 이동
            for (int i = endRow - 1; i >= startRow; i--) {
                tmp2 = arr[i][startCol];
                arr[i][startCol] = tmp;
                tmp = tmp2;
                min = Math.min(min, tmp);
            }

            r[cnt++] = min;
        }

        return r;
    }
}