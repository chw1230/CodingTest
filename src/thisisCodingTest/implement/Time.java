package thisisCodingTest.implement;

import java.util.Scanner;

public class Time {
    public static void main(String[] args) {
        int cnt = 0;
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for (int h = 0; h < n+1; h++) {
            String hText = h + ""; // int 형을 String 으로 바꾸는 간단한 방법
            for (int m = 0; m < 60; m++) {
                String mText = m + ""; // int 형을 String 으로 바꾸는 간단한 방법
                for (int s = 0; s < 60; s++) {
                    String sText = s + ""; // int 형을 String 으로 바꾸는 간단한 방법
                    if (hText.contains("3") || mText.contains("3") || sText.contains("3")) { // .contains( )을 활용하여 구하기
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
