package thisisCodingTest.dynamicProgramming;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        System.out.println(fibo(N));
    }

    private static int fibo(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
        /*
        이과 같은 피보나치 구현은 엄청난 시간 낭비임! O(2^n)의 시간이 소요됨 -> n이 늘어나면 기하급수적으로 증가!
        다이나믹 프로그램을 사용하면 효율적으로 해결가능!
         */
    }
}
