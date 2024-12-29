package src.practice;

import java.util.Scanner;

public class BOJ11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coin = new int[N];
        int cnt = 0;
        for (int i = 0; i < coin.length; i++) {
            coin[i] = sc.nextInt();
        }

        for (int i = coin.length-1 ; i > -1; i--) {
            if(coin[i] <= K){
                cnt += K / coin[i];
                K %= coin[i];
            }
        }
        System.out.println(cnt);
    }
}
