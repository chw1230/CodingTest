package thisisCodingTest.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        int sum = 0;

        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                deque.pop();
            } else {
                deque.push(n);
            }
        }

        for (Integer integer : deque) {
            sum += integer;
        }
        System.out.println(sum);
    }
}
