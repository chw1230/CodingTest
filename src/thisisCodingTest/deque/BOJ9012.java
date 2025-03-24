package thisisCodingTest.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/* C언어 자료구조 과제로 나온 문제와 비슷한거 자바로 풀기
괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다. 한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다.
만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다. 그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다.
예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다.

지속적인 오류 이유 :'(' 와 ')'를 같은지 확인하는 조건문을 잘못 작성해서 계속 오류가 발생했었음!

해결 흐름 :
좌측 괄호 이면 스택에 넣고 우측 괄호이면 스택에서 pop해서 스택에 저장된 좌측괄호 없애기 그리고 우측 괄호일때 스택에 아무 것도 없으면 우측 괄호 좌측 괄호보다 더 많이 입력된 잘 못된 상황을 의미하는 것!
이 과정을 쭉 하고 스택에 뭔가 남았다 -> 이 경우는 좌측 괄호가 우측 괄호보다 더 많이 입력된 VPS 가 아닌 상황인 것!
스택에 뭔가 없다 -> VPS
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
