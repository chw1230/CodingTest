import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        int a = -1; // 요격위치

        for (int i = 0; i < targets.length; i++) {
            int s =  targets[i][0];
            int e = targets[i][1];

            if (s >= a) {
                answer++;
                a = e;
            }
        }

        return answer;
    }
}