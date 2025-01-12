package thisisCodingTest.Greedy;

import java.util.Scanner;

// 거스름돈
public class Change {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] change = {500, 100, 50, 10};
        int minCnt = 0;

        int money = sc.nextInt();
        for (int i : change) {
            minCnt += money / i;
            money %= i;
        }
        System.out.println(minCnt);
    }
}
