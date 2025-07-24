import java.util.Deque;
import java.util.LinkedList;

class Solution {
    static boolean solution(String s) {
        boolean answer = true;

        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if ( s.charAt(i) == '(') {
                dq.push(i);
            } else { // ')'인 경우
                if ( dq.isEmpty() ) { // 스택이 비어있으면 
                    answer = false; // 오답 처리
                } else { // // 스택이 차있다면
                    dq.pop(); // ')' 빼주기
                }
            }
        }
        
        if ( !dq.isEmpty() ) { // 다 돌고나서 완벽한 괄호 구조 였다면 아무 것도 들어 있으면 X!
            answer = false;
        }
        return answer;
    }

}