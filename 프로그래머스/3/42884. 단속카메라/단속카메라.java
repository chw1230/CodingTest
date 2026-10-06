import java.util.*;

class Solution {
    public static int solution(int[][] routes) {
        int cnt = 0;

        Arrays.sort(routes, (a, b) -> (a[1] - b[1]));

        int pos = Integer.MIN_VALUE;
        for (int i = 0; i < routes.length; i++) {
            int start = routes[i][0];
            int end = routes[i][1];

            if ( pos < start ) {
                cnt++;
                pos = end;
            }
        }
        return cnt;
    }
}