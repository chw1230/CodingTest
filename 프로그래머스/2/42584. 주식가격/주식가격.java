import java.util.Stack;

class Solution {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = prices.length - 1; i > -1; i--) {
            stack.push(prices[i]);
        }

        int cnt = 0;
        int idx = 0;
        while (!stack.isEmpty()) {
            int p = stack.pop();
            for (int i = idx + 1; i < prices.length; i++) {
                cnt++;
                if (p > prices[i]) {
                    break;
                }
            }
            answer[idx++] = cnt;
            cnt = 0;
        }
        return answer;
    }
}