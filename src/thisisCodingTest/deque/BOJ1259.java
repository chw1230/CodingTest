package thisisCodingTest.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 스택으로 팰린드롬 문제 풀기 -> 자료구조(C) 언어 수업 과제를 자바로 풀어보기!
public class BOJ1259 {
    public static String num;
    public static Deque<Character> stack;
    public static int len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            num = br.readLine();
            if (num.equals("0")) {
                break;
            }
            len = num.length();
            stack = new ArrayDeque<>();

            // 스택에 넣기
            for (int i = 0; i < len/2; i++) {
                stack.push(num.charAt(i));
            }
//            System.out.println(stack);
            palindrome();
        }
    }

    private static int palindrome() {
        if (len % 2 == 0) {
            // 짝수
            for (int i = len /2; i < len; i++) {
                char save = stack.pop();
                if (save != num.charAt(i)) {
                    // 틀린 경우
                    System.out.println("no");
                    return 0;
                }
            }

        } else {
            // 홀수
            for (int i = len /2 + 1; i < len; i++) {
                char save = stack.pop();
                if (save != num.charAt(i)) {
                    // 틀린 경우
                    System.out.println("no");
                    return 0;
                }
            }
        }

        System.out.println("yes");
        return 0;
    }
}

