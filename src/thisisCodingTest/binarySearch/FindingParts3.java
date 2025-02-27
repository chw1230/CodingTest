package thisisCodingTest.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class FindingParts3 {
    private static int N;
    private static int M;
    private static int[] arrN = new int[1000001];

    // 계수 정렬로 부품 찾기 풀기
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("N = ");
        N = s.nextInt();
        for (int i = 0; i < N; i++) {
            arrN[s.nextInt()] = 1;
        }

        System.out.print("M = ");
        M = s.nextInt();
        for (int i = 0; i < M; i++) {
            if (arrN[s.nextInt()] == 1) {
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }
    }

}
