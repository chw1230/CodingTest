package thisisCodingTest.Greedy;

import java.util.Scanner;

public class BOJ5585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = 1000 - sc.nextInt();
        int[] arr = {500, 100, 50, 10, 5, 1};
        int cnt = 0;
        for (int i : arr) {
            cnt += money / i;
            money %= i;
        }
        System.out.println(cnt);
    }
}
