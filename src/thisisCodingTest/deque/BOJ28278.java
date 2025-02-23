package thisisCodingTest.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ28278 {

    public static void main(String[] args) throws IOException {
        Deque<String> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] c = br.readLine().split(" ");

            switch (c[0]) {
                case "1":
                    deque.push(c[1]);
                    break;

                case "2":
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.pop());

                    }
                    break;

                case "3":
                    System.out.println(deque.size());
                    break;

                case "4":
                    if (deque.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;

                case "5":
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.peek());
                    }
            }
        }
    }
}
