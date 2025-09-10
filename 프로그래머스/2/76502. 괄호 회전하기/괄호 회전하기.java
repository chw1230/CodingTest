import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
class Solution {
       public static int solution(String s) {
        Map<Character,Character> map = new HashMap<>(); // 우측괄호 좌측괄호
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        int cnt = 0;

        int len = s.length();
        s += s; // 괄호가  빙글빙글 돌아가도록 문자열을 연결하기
//        System.out.println(s);
        A : for (int i = 0; i < len; i++) {
            Deque<Character> stack = new ArrayDeque<>();
            for (int j = i; j < i + len; j++) { // 회전된 문자열에서 도는 것 처럼, 문자열 길이 만큼
                char c = s.charAt(j);
                if (!map.containsKey(c)) { // key에 없으면 좌측 괄호
                    stack.push(c);
                } else {
                    if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                        continue A;
                    }
                }
            }
            if (stack.isEmpty()) {
                cnt++;
            }
        }
        return cnt;
    }
}