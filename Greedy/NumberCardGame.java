package thisisCodingTest.Greedy;

import java.util.Scanner;

// 배열에 대해서 익숙하지 않은 느낌이 났다! -> 자바로 배열 관련 문제좀 풀어야 할듯!
public class NumberCardGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] number = new int[N][M];
        int[] min = new int[N];
        // 배열에 넣어주기
        for (int i = 0; i < N; i++) {
            min[i] = 10001;
            for (int j = 0; j < M; j++) {
                number[i][j] = sc.nextInt();
                if( min[i] > number[i][j]){
                    min[i] = number[i][j];
                }
            }
        }

        int max = 0;
        for (int i = 0; i < min.length; i++) {
            if(max <= min[i]){
                max = min[i];
            }
        }
        System.out.println(max);
    }
}
