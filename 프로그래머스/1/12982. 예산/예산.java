import java.util.Arrays;

class Solution {
    public static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        for (int v : d) {
            if (budget < v) {
                break;
            }
            budget -= v;
            answer++;
        }
        return answer;
    }
}