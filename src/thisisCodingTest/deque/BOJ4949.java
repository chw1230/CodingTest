package thisisCodingTest.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/*
전에 풀었던 BOJ9012번과 유사해서 어렵지 않았음 하지만
문제에서 요구하는 조건을 잘못 파악함! -> '.' 을 입력했을 때 그냥 종료인데 'yes'를 출력하고 종료하는 바람에 한번에 맞추지 못함!
 */

public class BOJ4949 {
    public static Deque<Character> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while (true) {
            str = br.readLine();
            stack = new ArrayDeque<>();

            if (str.equals(".")) { // 종료
                return;
            }

            extracted(str);
        }
    }

    private static int extracted(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == ']') {
                if (stack.isEmpty()) {
                    // 실패 -> 좌측 괄호보다 우측이 먼저 나온 경우
                    System.out.println("no");
                    return 0;
                }
                char save = stack.pop();
                if ((c == ')' && save != '(') || (c == ']' && save != '[')) {
                    // 실패
                    System.out.println("no");
                    return 0;
                }
            }
        }

        // 다 돌고나서
        if (stack.isEmpty()) { // 스택이 비어 있으면
            System.out.println("yes");
        } else {
            // 비지 않으면
            System.out.println("no");
        }
        return 0;
    }
}
