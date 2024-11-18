package thisisCodingTest.Greedy;

import java.util.Scanner;

public class BOJ2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kg = sc.nextInt();
        int cnt = 0;

        while(kg != 0){
            if (kg<3){
            System.out.println(-1);
            return;
            }
            if(kg % 5 == 0){
                cnt += kg / 5;
                kg = kg % 5;
            }else{
                // 3kg 한 묶음을 묶어내기 -> (봉지 1개 늘어남)cnt++;
                kg -= 3;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
