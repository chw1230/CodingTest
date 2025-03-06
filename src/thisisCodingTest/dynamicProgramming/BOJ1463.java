package thisisCodingTest.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class BOJ1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] v = new int[N+1];

        for (int i = 2; i <= N; i++) {
            // 다텀탑으로 짜기
            v[i] = v[i - 1] + 1;// -1을 해주는 경우

            if (i % 2 == 0) { // 2로 나누어 떨어지는 경우
                v[i] = Math.min(v[i], v[i / 2] + 1); // -1의 경우와 2로 나누어 떨어지는 경우 중 작은값 전달
            }
            if (i % 3 == 0) { // 3으로 나누어 떨어지는 경우
                v[i] = Math.min(v[i], v[i / 3] + 1); // -1의 경우와 3로 나누어 떨어지는 경우 중 작은값 전달
            }
        }
        System.out.println(v[N]);

    }
}
