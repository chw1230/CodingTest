package thisisCodingTest.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch2 {
    // 반복문을 활용한 이진 탐색
    private static int find;
    private static int cnt = 0;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("요소의 개수 입력");
        int n = s.nextInt();
        arr = new int[n];
        System.out.println("요소 입력");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
        Arrays.sort(arr);  // 이진 탐색은 이미 정렬되어 있어야 사용가능 하기에 정렬 실행해주기~

        System.out.println("찾으려는 값 입력");
        find = s.nextInt();

        binarySearch( 0, n-1);
    }

    private static void binarySearch(int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] < find) {
                cnt++;
                start = mid + 1;
            } else if (arr[mid] > find) {
                cnt++;
                end = mid - 1;
            } else {
                System.out.print("찾았다 ");
                System.out.println("cnt = " + cnt);
            }
        }
        System.out.println(-1);
    }
}
