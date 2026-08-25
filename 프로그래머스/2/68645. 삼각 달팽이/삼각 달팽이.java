class Solution {
     public static int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2]; // 1부터 n까지의 합만큼 숫자가 나열됨

        int[][] arr = new int[n][n];
        int num = 1;

        int i = -1, j = 0;

        // K번 꺾임(방행 전환)
        for (int k = 0; k < n; k++) {

            // l 직전하는 횟수
            for (int l = k; l < n; l++) {

                if (k % 3 == 0) { // 아래로
                    i++;
                } else if (k % 3 == 1) { // 우측으로
                    j++;
                } else if (k % 3 == 2) { // 좌측 상단 대각으로
                    i--;
                    j--;
                }

                arr[i][j] = num++;
            }
        }

        int cnt = 0;
        for (int k = 0; k < arr.length; k++) {
            for (int l = 0; l < arr.length; l++) {
                if (arr[k][l] != 0) {
                    answer[cnt++] = arr[k][l];
                }
            }
        }
        return answer;
    }
}