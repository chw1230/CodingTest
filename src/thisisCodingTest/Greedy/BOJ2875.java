package thisisCodingTest.Greedy;

import java.util.Scanner;

public class BOJ2875 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N,M,K,cnt=0;
        N = scanner.nextInt();
        M = scanner.nextInt();
        K = scanner.nextInt();

        while(N-2>=0 && M-1 >= 0 && M+N>=3+K){
            N = N -2;
            M--;
            cnt++;
        }
        System.out.println(cnt);
    }
}
