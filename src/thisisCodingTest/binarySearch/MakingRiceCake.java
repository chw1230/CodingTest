package thisisCodingTest.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class MakingRiceCake {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        int[] arr = new int[N];
        int mid;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
        Arrays.sort(arr);

        int start = arr[0];
        int end = arr[N - 1];
        while (true) {
            int sum = 0;
            mid = (start + end) / 2;

            for (int i : arr) {
                if (i > mid) {
                    sum += i - mid;
                }
            }

            if (sum > M) {
                start = mid + 1;
            } else if (sum < M) {
                end = mid - 1;
            }else{
                System.out.println(mid);
                break;
            }
        }
    }
}
