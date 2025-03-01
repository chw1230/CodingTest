package thisisCodingTest.deque;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new ArrayDeque<>();
        // deque를 활용해서 문제 풀기 -> println을 사용하다보니 시간초과 나옴 -> BufferedWriter 사용에 익숙해지기!( 시간 초과 해결 )
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str) {
                case "push" -> {
                    deque.offer(Integer.parseInt(st.nextToken()));
                }
                case "pop" -> {
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.poll() + "\n");
                    }
                }
                case "size" -> {
                    bw.write(deque.size() + "\n");
                }
                case "empty" -> {
                    if (deque.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                }
                case "front" -> {
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.peek() + "\n");
                    }
                }
                case "back" -> {
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.getLast() + "\n");
                    }
                }
            }
        }
        bw.flush(); // 한번에 출력
        bw.close();
    }
}
