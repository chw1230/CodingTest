package thisisCodingTest.Greedy;

import java.util.Scanner;

public class BOJ11047 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int money = scanner.nextInt();
        int[] arr = new int[N];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = N-1; i >= 0; i--) {
            if ((money != 0) && (money % arr[i] >= 0) && (money / arr[i] > 0)) {
                cnt += money / arr[i];
                money = money % arr[i];
            }
        }
        System.out.println(cnt);
    }
}
