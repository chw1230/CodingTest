package src.practice;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        // 정렬
        Arrays.sort(arr);

        int sum = 0;
        int totalTime = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            totalTime += sum;
        }
        System.out.println(totalTime);
    }
}
