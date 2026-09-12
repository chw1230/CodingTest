class Solution {
    public static int solution(int n) {
        int answer = 1;
        int sum;

        // 시작하는 수
        for (int i = 1; i <= n; i++) {
            sum = i;
            for (int j = i + 1; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                } else if (sum > n) {
                    break;
                }
            }
        }
        // System.out.println(answer);
        return answer;
    }
}