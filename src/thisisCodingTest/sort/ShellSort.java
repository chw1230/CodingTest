package src.thisisCodingTest.sort;

import java.util.Arrays;
import java.util.Scanner;

public class ShellSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정렬할 숫자의 수를 입력: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("수 입력 : ");
            arr[i] = scanner.nextInt();
        }

        System.out.print("Before sort : ");
        System.out.println(Arrays.toString(arr));

        shellSort(arr);
        System.out.print("After shell sort : ");
        System.out.println(Arrays.toString(arr));

    }

    private static void shellSort(int[] arr) {
        int len = arr.length;

        for (int gap = len / 2; 0 < gap; gap = gap / 2) {
            for (int i = gap; i < len; i++) {
                for (int j = i - gap; 0 <= j && arr[j+gap] < arr[j]; j = j - gap) {
                    int tmp = arr[j];
                    arr[j] = arr[j + gap];
                    arr[j + gap] = tmp;
                }
            }
        }

    }


}
