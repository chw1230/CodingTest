package practice;

import java.util.Scanner;

public class BOJ11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String numStr = sc.nextLine();
        char[] arr = numStr.toCharArray(); // char형 배열 생성
        // toCharArray함수 -> String형으로 입력받은 값을 char[]형으로 변환한다.
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += arr[i] - '0';
        }
        System.out.println(sum);

        //향상된 for문
        /*
        sum = 0;
        for (char c : arr) {
            sum += c - '0';
        }
        System.out.println(sum);
        */

        /*
        "12345" --toCharArray()--> '1','2','3','4','5' --아스키코드 성질 이용--> 각 인덱스의 값들 - '0' --> 문자를 숫자로 변환
         */
    }
}