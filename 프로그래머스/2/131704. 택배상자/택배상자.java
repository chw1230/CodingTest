import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public static int solution(int[] order) {
        int cnt = 0;

        Stack<Integer> stack = new Stack<>(); // 저장소 컨테이너 벨트

        for (int i = 1; i <= order.length; i++) {
            if (order[cnt] == i) {
                cnt++;
                if (i == order.length) {
                    i--;
                }
            } else {
                if (!stack.isEmpty() && (stack.peek() == order[cnt])) {
                    stack.pop();
                    cnt++;
                    i--;
                    if ( cnt ==  order.length) {
                        return cnt;
                    }
                } else {
                    stack.push(i);
                }
            }
        }
        return cnt;
    }
}