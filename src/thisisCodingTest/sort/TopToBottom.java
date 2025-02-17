package thisisCodingTest.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TopToBottom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] arr = new Integer[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder()); // 내림차순 정렬

        for (Integer i : arr) {
            System.out.print(i+" ");
        }
    }
}
