package thisisCodingTest.sort;

import java.util.Arrays;
import java.util.Scanner;

public class ChangeElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N,K;
        N = scanner.nextInt();
        K = scanner.nextInt();
        scanner.nextLine(); // 버퍼 삭제

        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = scanner.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < K; i++) {
            if(A[i] < B[N-i-1]){
                A[i] = B[N-i-1];
            }
        }

        int sum =0;
        for (int i : A) {
            sum += i;
        }
        System.out.println(sum);
    }
}
