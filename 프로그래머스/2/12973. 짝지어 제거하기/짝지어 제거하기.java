import java.util.ArrayDeque;
import java.util.Deque;
class Solution
{
    public static int solution(String s)
    {
        int answer = -1;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) { // 일단 비어 있으면 넣기
                stack.push(c);
            } else { // 존재하는 경우
                char save = stack.pop();
                if (c != save) { // 짝지어 지지 않는 경우
                    stack.push(save);
                    stack.push(c);
                }
            }
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return stack.isEmpty() ? 1 : 0;
    }
}