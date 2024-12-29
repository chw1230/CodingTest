package src.practice;

import java.util.Scanner;

public class BOJ21734 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] strArr = str.toCharArray();
        for (char c : strArr) {
            int num = c - 0;
            int sum = num/100 + (num/10 - (num/100)*10) + num%10;
            for (int i = 0; i < sum; i++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
