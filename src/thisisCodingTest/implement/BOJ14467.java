package thisisCodingTest.implement;

import java.util.Scanner;

public class BOJ14467 {
    public static void main(String[] args) {
        // 소가 길을 건너간 이유1
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[10];
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 2;
        }
        for (int i = 0; i < n; i++) {

            int num = scanner.nextInt();
            int position = scanner.nextInt();
            if(arr[num-1] < 2){
                if( arr[num-1] != position){
                    cnt++;
                }
            }
            arr[num-1] = position;
        }
        System.out.println(cnt);
    }
}
