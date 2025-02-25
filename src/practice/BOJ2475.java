package practice;

import java.util.Scanner;

public class BOJ2475 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int n = scanner.nextInt();
            sum += n * n;
        }
        System.out.println(sum%10);
    }
}
