package thisisCodingTest.deque;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> stack = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push" -> {
                    stack.push(Integer.valueOf(st.nextToken()));
                }
                case "pop" -> {
                    if (stack.isEmpty()) {
                        bw.append("-1\n");
                    }else {
                        bw.write(stack.pop()+"\n");
                    }
                }
                case "size" -> {
                    bw.write(stack.size()+"\n");
                }
                case "empty" -> {
                    if (stack.isEmpty()) {
                        bw.write(1+"\n");
                    }else {
                        bw.write(0+"\n");
                    }
                }
                case "top" -> {
                    if (stack.isEmpty()) {
                        bw.write(-1+"\n");
                    }else {
                        bw.write(stack.peek()+"\n");
                    }
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
