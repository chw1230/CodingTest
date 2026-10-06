import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int cnt = 0;

        // end 오름차순
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);

        int pos = Integer.MIN_VALUE;
        for (int i = 0; i < targets.length; i++) {
            int start = targets[i][0];
            int end = targets[i][1];

            if (pos <= start) {
                cnt++;
                pos = end;
            }
        }
        return cnt;
    }
}