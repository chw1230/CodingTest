package SWEA.D1;

import java.util.Scanner;

public class SWEA2072 {
    // 홀수만 더하기
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                int num = scanner.nextInt();
                sum += (num % 2 == 0) ? 0 : num;
            }
            System.out.println("#"+(i+1)+" "+sum);
        }

    }
}
