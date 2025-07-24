import java.util.Stack;

class Solution {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = prices.length-1; i > -1; i--) {
            stack.push(prices[i]);
        }

        int idx = 1;
        while (!stack.isEmpty()) {
            int cnt = 0;
            int pop = stack.pop();
            for (int i = idx; i < answer.length; i++) {
                if (pop <= prices[i]) {
                    ++cnt;
                } else {
                    ++cnt;
                    break;
                }
            }
            answer[idx-1] = cnt;
            idx++;
        }
        return answer;
    }
}