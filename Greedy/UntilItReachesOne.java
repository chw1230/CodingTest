package thisisCodingTest.Greedy;

import java.util.Scanner;

public class UntilItReachesOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int cnt = 0;

        while( N != 1){
            if( N % K != 0){
                N -= 1;
            }else{
                N /= K;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
