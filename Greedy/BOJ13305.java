package thisisCodingTest.Greedy;

import java.util.Scanner;

public class BOJ13305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr1 = new int[N-1];
        int[] arr2 = new int[N];
        int sum = 0;

        // 주유소 사이의 거리 입력
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        // 주유소의 가격 입력
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }

        for (int i = 0; i < arr2.length - 1; i++) {
            if(arr2[i] < arr2[i+1]){  // i번째 값이 i+1값 보다. 큰 경우 i+1 번째 값을 i번째 값으로 바꿔 주는 과정
                arr2[i + 1] = arr2[i];
            }
            sum += arr1[i] * arr2[i];
        }
        System.out.println(sum);
    }
}
