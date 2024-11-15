package thisisCodingTest.Greedy;

import java.util.Arrays;
import java.util.Scanner;

// 큰 수의 법칙
public class LawOfLargeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int M = sc.nextInt();
        int K = sc.nextInt();

        // 배열 입력
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // 정렬 시키기
        Arrays.sort(arr, 0, N);

        // 합 구하기
        int sum = ((arr[N-1] * K) + arr[N-2]) * (M/(K+1)) + arr[N-1] * (M % (K+1));
        System.out.println(sum);
    }
}
