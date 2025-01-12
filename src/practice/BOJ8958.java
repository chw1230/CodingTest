package practice;

import java.util.Scanner;

public class BOJ8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            int sum = 0;
            int cnt = 0;
            char[] arr = sc.nextLine().toCharArray();
            for (int j = 0; j < arr.length; j++) {
                /* 연속해서 O가 나오면 cnt에 값이 축척되어 sum에 더해질 것이고,
                연속이 끊기면 cnt 가 0으로 초기화 될 것이다!!!!
                 */
                if (arr[j] == 'O') {
                    cnt++;
                    sum += cnt;
                }
                else {
                    cnt = 0;
                }
            }
            System.out.println(sum);
        }
    }
}


