class Solution {
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int cnt = 1;
        int[][] arr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = cnt++;
            }
        }

        // queries.length 번 회전
        for (int i = 0; i < queries.length; i++) {

            int[] query = queries[i];
            answer[i] = turn(query, arr);

        }
        return answer;
    }

    private static int turn(int[] query, int[][] arr) {
        // A
        int aRow = query[0] - 1;
        int aCol = query[1] - 1;

        // B
        int bRow = query[2] - 1;
        int bCol = query[3] - 1;

        // 회전하는 수 중 가장 작은 값
        int min = Integer.MAX_VALUE;

        // 숫자들을 하나씩 바꾸는 횟수
        int cnt = (bRow - aRow) * 2 + (bCol - aCol) * 2;
        int postRow = aRow;
        int postCol = aCol;
        System.out.println(cnt);
        int tmp = arr[aRow][aCol]; // 시작 값을 넣기
        for (int i = 0; i < cnt; i++) {

            if (postRow == aRow && postCol < bCol) { // 우측으로 이동하는 경우
                postCol++; // 우측으로 이동하기
            } else if (postRow < bRow && postCol == bCol) { // 우측 끝에 도달
                postRow++; // 아래로 내려가기
            } else if (postRow == bRow && postCol >  aCol) { // 우측 하단에 도달
                postCol--; // 좌측으로 이동하기
            } else if (postRow > aRow && postCol == aCol) { // 좌측 하단에 도달
                postRow--; // 위로 올라가기
            }

            int num = arr[postRow][postCol];
            min = Math.min(min, num);
            arr[postRow][postCol] = tmp;
            tmp = num;
        }
        return min;
    }
}