package thisisCodingTest.implement;

import java.util.Scanner;

public class BOJ20546 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 처음 시작 돈
        int[] per = new int[14]; // 주가
        int JMoney = N;
        int JStock = 0;
        int Jsum = 0;

        int SMoney = N;
        int SStock = 0;
        int Ssum = 0;
        for (int i = 0; i < 14; i++) {
            per[i] = scanner.nextInt();
            System.out.println(1);

            // 준현이
            while (JMoney >= per[i]) {
                JMoney -= per[i];
                JStock++;
            }
        }
        Jsum = JStock * per[13];


        for (int i = 3; i < 14; i++) {

            // 성민이
            // 매수
            if(per[i-3]<per[i-2] && per[i-2]<per[i-1] && per[i-1]<per[i]){
                // 성민이 풀매도
                SMoney = SStock * per[i];
                SStock = 0;
            } else if (per[i-3]>per[i-2] && per[i-2]>per[i-1] && per[i-1]>per[i]) {
                // 성민이 풀매수
                while (SMoney >= per[i]) {
                    SMoney -= per[i];
                    SStock++;
                }
            }

        }
        if (SStock != 0) {
            Ssum += SMoney;
        }else {
            Ssum = SMoney;
        }

        System.out.println("Jsum = " + Jsum);
        System.out.println("Ssum = " + Ssum);
    }
}
