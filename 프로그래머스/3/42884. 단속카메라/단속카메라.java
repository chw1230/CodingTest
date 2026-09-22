import java.util.*;

class Solution {
    public static int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        int a = -30001;

        for (int[] route : routes) {
            int s = route[0];
            int e = route[1];

            if (a < s) {
                answer++;
                a = e;
            }
        }

        return answer;
    }
}