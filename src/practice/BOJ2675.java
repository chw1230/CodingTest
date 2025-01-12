package practice;

import java.util.Scanner;

public class BOJ2675 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int R = sc.nextInt();
            String S = sc.next();
            for (int j = 0; j < S.length(); j++) {
                for (int m = 0; m < R; m++) {
                    System.out.print(S.charAt(j));
                }
            }
            System.out.println();
        }
    }
}
