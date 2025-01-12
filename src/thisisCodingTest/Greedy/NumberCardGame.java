package thisisCodingTest.Greedy;

import java.util.Scanner;

public class NumberCardGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int result = 0;

        // 굳이 배열 사용할 필요가 없음!!!
        // 한 줄씩 입력 받아 확인하기
        for (int i = 0; i < N; i++) {
            // 현재 행에서 '가장 작은 수' 찾기
            int min_value = 10001;
            for (int j = 0; j < M; j++) {
                int x = sc.nextInt();
                min_value = Math.min(min_value, x);
            }
            // '가장 작은 수'들 중에서 가장 큰 수 찾기
            result = Math.max(result, min_value);
        }
        System.out.println(result); // 최종 답안 출력
    }
}

