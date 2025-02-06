package thisisCodingTest.implement;

import java.util.Scanner;

public class BOJ5554 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int x = (a+b+c+d)/60;
        int y = (a+b+c+d)%60;
        System.out.println(x);
        System.out.println(y);
    }
}
