package src.thisisCodingTest.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/* C언어 자료구조 과제로 나온 문제와 비슷한거 자바로 풀기
처음에 했던 실수 ( 와 ')'를 같은지 확인하는 조건문을 잘못 작성해서 계속 오류가 발생했었음!
 */
public class BOJ9012 {
    public static Deque<Character> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            deque = new ArrayDeque<>();

            if (extracted(str)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean extracted(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') { // 좌측 괄호면 스택에 넣기
                deque.push(c);
            } else { // 우측 괄호면 팝해서 비교
                if (deque.isEmpty()) { // 우측 괄호인데 스택이 비어서 비교불가한 경우 -> 우측괄호만 있는 경우를 의미
                    return false;
                } else {
                    deque.pop();
                }
            }
        }
        return deque.isEmpty(); // 다 끝나고 비어있으면 참, 스택에 뭔가 있으면 안됨! 거짓 반환
    }
}
