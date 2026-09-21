import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        int n = order.length;

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (order[answer] == i) {
                answer++;
                if ( i == n) {
                    i--;
                }
            } else if (!stack.isEmpty() && stack.peek() == order[answer]) {
                stack.pop();
                answer++;
                i--;
                if ( answer == n) {
                    return answer;
                }
            } else {
                // 다르면
                stack.push(i);
            }

        }
        return answer;
    }
}