package thisisCodingTest.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class FindingParts1 {
    private static int N;
    private static int M;
    private static int[] arrN;
    private static int[] arrM;

    // 이진 탐색으로 부품 찾기 풀기
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("N = ");
        N = s.nextInt();
        arrN = new int[N];
        for (int i = 0; i < N; i++) {
            arrN[i] = s.nextInt();
        }
        Arrays.sort(arrN);

        System.out.print("M = ");
        M = s.nextInt();
        arrM = new int[M];
        for (int i = 0; i < M; i++) {
            arrM[i] = s.nextInt();
            System.out.println((binarySearch(0, N - 1, arrM[i])==true) ?"yes":"no");
        }
    }

    private static boolean binarySearch(int start, int end, int find) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arrN[mid] < find) {
                start = mid + 1;
            } else if (arrN[mid] > find) {
                end = mid - 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
