package thisisCodingTest.dynamicProgramming;

import java.util.Scanner;

public class MakeOne {
    private static int[] v = new int[30001];
    // v 배열은 1부터 주어진 N 까지 계산하는데 걸리는 최솟값을 저장할 거임!

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 2; i < N+1; i++) {
            // 바텀업 방식으로 코드를 짜기

            // 그러므로 코드가 2,3,5로 나누어 떨어지지 않는 경우일때 -1을 하는 케이스를 반대로
            // 하기 때문에 더하기 1을 해주는 것!!
            v[i] = v[i - 1] + 1;

            if (i % 2 == 0) { // 현재의 수가 2로 나누어 떨어지는 경우
                // -1을 하는 케이스와 비교해서 더 작은 값을 저장하기!
                v[i] = Math.min(v[i], v[i / 2] + 1);
            }
            if (i % 3 == 0) { // 현재의 수가 3으로 나누어 떨어지는 경우
                // -1을 하는 케이스와 비교해서 더 작은 값을 저장하기!
                v[i] = Math.min(v[i], v[i / 3] + 1);
            }
            if (i % 5 == 0) { // 현재의 수가 5로 나누어 떨어지는 경우
                // -1을 하는 케이스와 비교해서 더 작은 값을 저장하기!
                v[i] = Math.min(v[i], v[i / 5] + 1);
            }
        }
        System.out.println(v[N]);
    }
}
